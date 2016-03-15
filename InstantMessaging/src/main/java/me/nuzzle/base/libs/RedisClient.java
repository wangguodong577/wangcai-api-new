package me.nuzzle.base.libs;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujinliang
 * @since 5/16/14
 */
public class RedisClient {
    /*2014-02-17 的时间*/
    private static final long TSL_20140217 = 1392566400000L;

    private static AtomicInteger nextIdx = new AtomicInteger(-1);

    private static String[] servers = StringUtils.split(Configure.getString("redis.servers"), ",");
    private static String password = Configure.getString("redis.pwd");
    private static JedisPoolConfig poolConfig = new JedisPoolConfig();

    static {
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        poolConfig.setMaxTotal(500);
        poolConfig.setMaxIdle(500);
        poolConfig.setMaxWaitMillis(1000 * 10);
    }

    private static List<JedisPool> pools = new ArrayList<JedisPool>();

    static {
        for (String server : servers) {
            String[] hostPort = StringUtils.split(server, ":");
            if (hostPort.length < 1) continue;
            String host = hostPort[0];
            int port = 6379;
            if (hostPort.length > 1) {
                port = NumberUtils.toInt(hostPort[1]);
            }
            JedisPool pool = new JedisPool(poolConfig, host, port, 10000 * 3, password);
            pools.add(pool);
        }
    }

    /**
     * 添加到zset,score是当前时间的毫秒数
     *
     * @param key     key
     * @param members members
     * @return
     */
    public static Long addToList(final String key, final String... members) {
        return addToList(0, key, members);
    }

    /**
     * 增加到redis的zset列表中去
     *
     * @param tsl     时间戳，为了计算list的score，一般是feed的created
     * @param key     list key
     * @param members list values
     */
    public static Long addToList(final long tsl, final String key, final String... members) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                Map<String, Double> scoreMembers = new HashMap<String, Double>();
                long time = tsl <= 0 ? System.currentTimeMillis() : tsl;
                double score = new Long(time).doubleValue();
                for (String member : members) {
                    scoreMembers.put(member, score);
                }
                return jedis.zadd(key, scoreMembers);
            }
        });
    }

    /**
     * 增加到redis的list列表中去
     *
     * @param score  score
     * @param key    list key
     * @param member value
     */
    public static Long addToListWithScore(final double score, final String key, final String member) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                Map<String, Double> scoreMembers = new HashMap<String, Double>();
                scoreMembers.put(member, score);
                return jedis.zadd(key, scoreMembers);
            }
        });
    }

    /**
     * 增加到redis的list列表中去
     *
     * @param score  score
     * @param key    list key
     * @param member value
     * @param second expire
     */
    public static void addToListWithScore(final double score, final String key, final String member, final int second) {
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                Map<String, Double> scoreMembers = new HashMap<String, Double>();
                scoreMembers.put(member, score);
                jedis.zadd(key, scoreMembers);
                jedis.expire(key, second);
                return null;
            }
        });
    }

    /**
     * 获得某个元素的分数
     *
     * @param key    key
     * @param member 元素
     * @return 分数
     */
    public static double getScoreForMember(final String key, final String member) {
        return execute(new RedisCallback<Double>() {
            @Override
            public Double execute(Jedis jedis) {
                return jedis.zscore(key, member);
            }
        });
    }

    /**
     * 从zset中移除指定的元素
     *
     * @param key     key
     * @param members 元素们
     * @return
     */
    public static Long removeFromList(final String key, final String... members) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.zrem(key, members);
            }
        });
    }

    /**
     * 从zset中移除score从min到max之间的所有元素
     *
     * @param key key
     * @param min min
     * @param max max
     * @return
     */
    public static Long removeFromList(final String key, final double min, final double max) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.zremrangeByScore(key, min, max);
            }
        });
    }

    /**
     * zset 从低到高排序,返回所有
     *
     * @param key key
     * @return 结果
     */
    public static Set<String> listFromList(final String key) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                return jedis.zrange(key, 0, -1);
            }
        });
    }

    /**
     * zset 从高到低排序返回所有
     *
     * @param key
     * @return
     */
    public static Set<String> listFromListByRevRange(final String key) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                return jedis.zrevrange(key, 0, -1);
            }
        });
    }

    /**
     * 从zset中倒序获取,分页
     *
     * @param key      key
     * @param page     page
     * @param pageSize pageSize
     * @return
     */
    public static Set<String> listFromListByRevRangeAndPage(final String key, final int page, final int pageSize) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                int start = (page - 1) * pageSize;
                start = start < 0 ? 0 : start;
                return jedis.zrevrange(key, start, start + pageSize - 1);
            }
        });
    }

    /**
     * 返回比member小的n条记录
     *
     * @param key      key
     * @param member   截止元素
     * @param pageSize 记录条数
     * @return
     */
    public static Set<String> listByLtMemberWithPagination(final String key, final String member, final int pageSize) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                double max = jedis.zscore(key, member);
                return jedis.zrevrangeByScore(key, max <= 0 ? Double.MAX_VALUE : max, 0, 0, pageSize);
            }
        });
    }

    public static Set<String> listByScoreWithPagination(final String key, final double min, final double max, final int page, final int pageSize) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                //后面2个参数是offset and count
                int start = (page - 1) * pageSize;
                start = start < 0 ? 0 : start;
                return jedis.zrevrangeByScore(key, max <= 0 ? Double.MAX_VALUE : max, min, start, pageSize);
            }
        });
    }

    public static Set<Tuple> listByScoreWithPagination(final String key, final double min, final double max) {
        return execute(new RedisCallback<Set<Tuple>>() {
            @Override
            public Set<Tuple> execute(Jedis jedis) {
                return jedis.zrevrangeByScoreWithScores(key, max <= 0 ? Double.MAX_VALUE : max, min);
            }
        });
    }

    public static Set<String> listByScore(final String key, final double min, final double max) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                return jedis.zrevrangeByScore(key, max <= 0 ? Double.MAX_VALUE : max, min);
            }
        });
    }

    public static Set<String> listByScoreAsc(final String key, final double min, final double max) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                return jedis.zrangeByScore(key, min, max <= 0 ? Double.MAX_VALUE : max);
            }
        });
    }

    public static Long count(final String key) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.zcard(key);
            }
        });
    }

    /**
     * 判断member是否在key对应的sorted set中
     *
     * @param key
     * @param member
     * @return
     */
    public static boolean exists(final String key, final String member) {
        return execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean execute(Jedis jedis) {
                Long ret = jedis.zrank(key, member);
                return ret != null && ret > -1;
            }
        });
    }

    public static Long unionZset(final String key, final String... otherKeys) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                ZParams zParams = new ZParams();
                zParams.weightsByDouble(1);
                zParams.aggregate(ZParams.Aggregate.MIN);
                return jedis.zunionstore(key, zParams, otherKeys);
            }
        });
    }

    /**
     * 判断member是否在key对应的set中
     *
     * @param key
     * @param member
     * @return
     */
    public static boolean existsInSet(final String key, final String member) {
        return execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean execute(Jedis jedis) {
                return jedis.sismember(key, member);
            }
        });
    }

    public static void set(final String key, final String value) {
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.set(key, value);
            }
        });
    }

    public static void rpush(final String key, final String... values) {
        execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.rpush(key, values);
            }
        });
    }

    public static Long pfadd(final String key, final String value) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.pfadd(key, value);
            }
        });
    }

    public static String get(final String key) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.get(key);
            }
        });
    }

    public static String getAndExpireIfPresent(final String key, final int seconds) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                String ret = jedis.get(key);
                if (ret != null) {
                    jedis.expire(key, seconds);
                }
                return ret;
            }
        });
    }

    /**
     * 保存到redis，若key存在，则不更新
     *
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public static String setAndExpire(final String key, final String value, final int seconds) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.set(key, value, "NX", "EX", seconds);
            }
        });
    }

    /**
     * 保存到redis，设置过期时间，若key存在，替换原值
     *
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public static String setAndExpireReplaceIfExist(final String key, final String value, final int seconds) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.setex(key, seconds, value);
            }
        });
    }

    public static String setAndExpire(final String key, final String value, final Date date) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                String result = jedis.set(key, value);
                jedis.expireAt(key, date.getTime() / 1000);
                return result;
            }
        });
    }

    public static Long add(final String key, final String... members) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.sadd(key, members);
            }
        });
    }

    public static Long addAndExpire(final String key, final int second, final String... members) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                Long sadd = jedis.sadd(key, members);
                if (sadd > 0) {
                    jedis.expire(key, second);
                }
                return sadd;
            }
        });
    }

    public static Long inc(final String key) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.incr(key);
            }
        });
    }

    public static Long decr(final String key) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.decr(key);
            }
        });
    }

    public static Long decrAndExpire(final String key, final int seconds) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                Long decr = jedis.decr(key);
                if (decr > 0) {
                    jedis.expire(key, seconds);
                }
                return decr;
            }
        });
    }

    public static Long incAndExpire(final String key, final int seconds) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                Long incr = jedis.incr(key);
                if (incr > 0) {
                    jedis.expire(key, seconds);
                }
                return incr;
            }
        });
    }

    public static Long length(final String key) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.scard(key);
            }
        });
    }

    public static void delete(final String key) {
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                jedis.del(key);
                return null;
            }
        });
    }

    public static void setBit(final String key, final long offset, final boolean value) {
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                jedis.setbit(key, offset, value);
                return null;
            }
        });
    }

    public static Long remove(final String key, final String... members) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.srem(key, members);
            }
        });
    }

    public static Set<String> list(final String key) {
        return execute(new RedisCallback<Set<String>>() {
            @Override
            public Set<String> execute(Jedis jedis) {
                return jedis.smembers(key);
            }
        });
    }


    public static void addToMap(final String key, final String field, final String value) {
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                jedis.hset(key, field, value);
                return StringUtils.EMPTY;
            }
        });
    }

    public static Map<String, String> map(final String key) {
        return execute(new RedisCallback<Map<String, String>>() {
            @Override
            public Map<String, String> execute(Jedis jedis) {
                return jedis.hgetAll(key);
            }
        });
    }

    public static String hmset(final String key, final Map<String, String> map) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.hmset(key, map);
            }
        });
    }

    public static String hmset(final String key, final Map<String, String> map, final int second) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                String result = jedis.hmset(key, map);
                jedis.expire(key, second);
                return result;
            }
        });
    }

    public static String getFromMap(final String key, final String field) {
        return execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.hget(key, field);
            }
        });
    }

    public static List<String> multiGet(final Collection<String> keys) {
        return multiGet(keys, null);
    }

    public static List<String> multiGet(final Collection<String> keys, final String prefix) {
        if (keys == null || keys.size() == 0) return new ArrayList<String>();
        return execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> execute(Jedis jedis) {
                if (StringUtils.isNotBlank(prefix)) {
                    CollectionUtils.transform(keys, new Transformer() {
                        @Override
                        public Object transform(Object o) {
                            return prefix + o;
                        }
                    });
                }
                String[] keysArray = keys.toArray(new String[keys.size()]);
                return jedis.mget(keysArray);
            }
        });
    }

    public static List<String> multiGet(final String... keys) {
        if (keys == null || keys.length == 0) return new ArrayList<String>();
        return execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> execute(Jedis jedis) {
                return jedis.mget(keys);
            }
        });
    }

    public static void multiSet(final String... keyvalues) {
        if (keyvalues == null || keyvalues.length == 0)
            return;
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                return jedis.mset(keyvalues);
            }
        });
    }

    public static void multiSetAndExpired(final int seconds, final String... keyvalues) {
        if (keyvalues == null || keyvalues.length == 0)
            return;
        execute(new RedisCallback<String>() {
            @Override
            public String execute(Jedis jedis) {
                String result = jedis.mset(keyvalues);
                for (int i = 0; i < keyvalues.length; i++) {
                    if (i % 2 == 0) {
                        jedis.expire(keyvalues[i], seconds);
                    }
                }
                return result;
            }
        });
    }

    /**
     * 声明元素的经纬度
     *
     * @param key    集合
     * @param lng    经度
     * @param lat    维度
     * @param member 元素
     * @return 添加的数量
     */
    public static Long geoadd(final String key, final double lng, final double lat, final String member) {
        return execute(new RedisCallback<Long>() {
            @Override
            public Long execute(Jedis jedis) {
                return jedis.geoadd(key, lng, lat, member);
            }
        });
    }

    /**
     * 查看给定元素的经纬度
     *
     * @param key     集合
     * @param members 元素们
     * @return 经纬度列表
     */
    public static List<GeoCoordinate> geopos(final String key, final String... members) {
        return execute(new RedisCallback<List>() {
            @Override
            public List<GeoCoordinate> execute(Jedis jedis) {
                return jedis.geopos(key, members);
            }
        });
    }

    /**
     * 查看给定元素附近的点
     *
     * @param key    集合
     * @param member 元素
     * @param radius 半径,单位英里
     * @return 附近的点的集合
     */
    public static List<GeoRadiusResponse> georadiusByMember(final String key, final String member, final double radius) {
        return execute(new RedisCallback<List>() {
            @Override
            public List<GeoRadiusResponse> execute(Jedis jedis) {
                return jedis.georadiusByMember(key, member, radius, GeoUnit.MI);
            }
        });
    }

    /**
     * 查看给定经纬度附近的点
     *
     * @param key    集合
     * @param lng    经度
     * @param lat    维度
     * @param radius 半径,单位英里
     * @return 附近的点的集合
     */
    public static List<GeoRadiusResponse> georadius(final String key, final double lng, final double lat, final double radius) {
        return execute(new RedisCallback<List>() {
            @Override
            public List<GeoRadiusResponse> execute(Jedis jedis) {
                return jedis.georadius(key, lng, lat, radius, GeoUnit.MI);
            }
        });
    }

    private static <T> T execute(RedisCallback<T> callback) {
        if (pools.size() == 0) {
            throw new RuntimeException("redis no pool");
        }
        // RoundRobin Pool模式
        JedisPool pool = null;
        for (; ; ) {
            int current = nextIdx.get();
            int next = current >= pools.size() - 1 ? 0 : current + 1;
            if (nextIdx.compareAndSet(current, next)) {
                pool = pools.get(next);
                break;
            }
        }
        if (pool == null) {
            throw new RuntimeException("redis pool error");
        }
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (callback != null) {
                return callback.execute(jedis);
            }
        } catch (JedisConnectionException e) {
            if (null != jedis) {
                pool.returnBrokenResource(jedis);
                jedis = null;
            }
        } finally {
            if (null != jedis)
                pool.returnResource(jedis);
        }
        return null;
    }

    public static List<JedisPool> getPools() {
        return pools;
    }

    public static interface RedisCallback<T> {
        T execute(Jedis jedis);
    }
}
