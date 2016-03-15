package me.nuzzle.base.services;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;
import me.nuzzle.base.common.Constants;
import me.nuzzle.base.libs.RedisClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客户端连接查找方法
 */
public class ServerChannelRouter {

    private static Map<String, SocketChannel> map = new ConcurrentHashMap<String, SocketChannel>();

    public static void add(String clientId, SocketChannel socketChannel) {
        map.put(clientId, socketChannel);
    }

    public static Channel get(String clientId) {
        if (StringUtils.isBlank(clientId)) {
            return null;
        }
        return map.get(clientId);
    }

    public static void remove(SocketChannel socketChannel) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == socketChannel) {
                map.remove(entry.getKey());
            }
        }
    }

    public static void registerServer(String server) {
        RedisClient.addToListWithScore(0, Constants.CACHE_AVAILABLE_SERVER_LIST, server);
    }

    public static void addConnCount4Server(String server) {
        double count = RedisClient.getScoreForMember(Constants.CACHE_AVAILABLE_SERVER_LIST, server);
        RedisClient.addToListWithScore(count + 1, Constants.CACHE_AVAILABLE_SERVER_LIST, server);
    }

    public static void removeConnCount4Server(String server) {
        double count = RedisClient.getScoreForMember(Constants.CACHE_AVAILABLE_SERVER_LIST, server);
        RedisClient.addToListWithScore(count - 1, Constants.CACHE_AVAILABLE_SERVER_LIST, server);
    }

    public static Set<String> getAllServers() {
        return RedisClient.listByScoreAsc(Constants.CACHE_AVAILABLE_SERVER_LIST, 0, 0);
    }

}
