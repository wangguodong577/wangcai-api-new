package me.nuzzle.base.dao;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.TableWriteItems;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import me.nuzzle.base.common.Constants;
import me.nuzzle.base.libs.Configure;
import me.nuzzle.base.libs.RedisClient;
import org.apache.commons.lang3.math.NumberUtils;
import redis.clients.jedis.Tuple;

import java.util.*;

public class ChatMessageDao extends DynamoDBDao {

    private static String TABLE_NAME = Configure.getString("chat.message.table.name", "nuzzle_chat_message_test");

    public List<Map<String, Object>> getChatMessagesBySessionId(String sessionId, Integer seq, int size, boolean forward) {
        if (seq == null || seq < 0) {
            seq = forward ? Integer.MAX_VALUE : 0;
        }
        String ltOrgt = forward ? "<" : ">";
        QuerySpec spec = new QuerySpec()
                .withMaxResultSize(size)
                .withKeyConditionExpression("sessionId = :sessionId and seq " + ltOrgt + " :seq")
                .withValueMap(new ValueMap()
                        .withString(":sessionId", sessionId)
                        .withInt(":seq", seq));
        ItemCollection<QueryOutcome> items = getTable(TABLE_NAME).query(spec);
        Iterator<Item> iterator = items.iterator();
        List<Map<String, Object>> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            result.add(item.asMap());
        }
        return result;
    }

    public void markAsRead(String sessionId, String userId, int seq) {
        try {
            QuerySpec spec = new QuerySpec()
                    .withKeyConditionExpression("sessionId = :sessionId and seq <= :seq")
                    .withFilterExpression("receiver = :userId and hasRead = :hasRead")
                    .withValueMap(new ValueMap()
                            .withString(":sessionId", sessionId)
                            .withInt(":seq", seq)
                            .withString(":userId", userId)
                            .withBoolean(":hasRead", false))
                    .withConsistentRead(true);
            ItemCollection<QueryOutcome> items = getTable(TABLE_NAME).query(spec);
            Iterator<Item> iterator = items.iterator();
            TableWriteItems tableWriteItems = new TableWriteItems(TABLE_NAME);
            while (iterator.hasNext()) {
                Item item = iterator.next();
                item.withBoolean("hasRead", true);
                tableWriteItems.addItemToPut(item);
            }
            int lastestUnreadSeq = NumberUtils.toInt(RedisClient.get(Constants.CACHE_KEY_SESSION_LASTEST_UNREAD + userId));
            getDB().batchWriteItem(tableWriteItems);
            if (lastestUnreadSeq <= seq) {
                RedisClient.removeFromList(Constants.CACHE_KEY_UNREAD_SESSION_LIST + userId, sessionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Tuple> getUnreadChatSessionByUserId(String userId) {
        return RedisClient.listByScoreWithPagination(Constants.CACHE_KEY_UNREAD_SESSION_LIST + userId, 0, 0);
    }

    public List<Map<String, Object>> getUnreadChatMessageBySessionIdAndUserId(String sessionId, String userId, int size) {
        int lastReadedMessageSeq = getLastestReadedMessageSeq(sessionId, userId);
        QuerySpec spec = new QuerySpec()
                .withMaxResultSize(size)
                .withKeyConditionExpression("sessionId = :sessionId and seq > :seq")
                .withFilterExpression("receiver = :userId and hasRead = :hasRead")
                .withValueMap(new ValueMap()
                        .withString(":sessionId", sessionId)
                        .withInt(":seq", lastReadedMessageSeq)
                        .withString(":userId", userId)
                        .withBoolean(":hasRead", false))
                .withConsistentRead(true);
        ItemCollection<QueryOutcome> items = getTable(TABLE_NAME).query(spec);
        Iterator<Item> iterator = items.iterator();
        List<Map<String, Object>> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            result.add(item.asMap());
        }
        return result;
    }

    public void saveChatMessage(String sessionId, String senderId, int seq, String receiverId, String type, String url, String content) {
        try {
            Item item = new Item()
                    .withPrimaryKey("sessionId", sessionId)
                    .withString("sender", senderId)
                    .withString("receiver", receiverId)
                    .withBoolean("hasRead", false)
                    .withInt("seq", seq)
                    .withNumber("sendTime", System.currentTimeMillis() / 1000)
                    .withString("url", url)
                    .withString("content", content)
                    .withString("type", type);
            getTable(TABLE_NAME).putItem(item);
            RedisClient.set(Constants.CACHE_KEY_SESSION_LASTEST_UNREAD + receiverId, String.valueOf(seq));
            double unread = RedisClient.getScoreForMember(Constants.CACHE_KEY_UNREAD_SESSION_LIST + receiverId, sessionId);
            RedisClient.addToListWithScore(unread + 1, Constants.CACHE_KEY_UNREAD_SESSION_LIST + receiverId, sessionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getLastestReadedMessageSeq(String sessionId, String userId) {
        return NumberUtils.toInt(RedisClient.get(Constants.CACHE_KEY_SESSION_LASTEST_READ + userId + "_" + sessionId));
    }

    public static void setLastestReadedMessageSeq(String sessionId, String userId, int seq) {
        RedisClient.set(Constants.CACHE_KEY_SESSION_LASTEST_READ + userId + "_" + sessionId, seq + "");
    }

}