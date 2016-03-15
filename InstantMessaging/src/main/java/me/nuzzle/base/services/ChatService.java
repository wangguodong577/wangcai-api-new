package me.nuzzle.base.services;

import me.nuzzle.base.common.Constants;
import me.nuzzle.base.libs.RedisClient;
import me.nuzzle.base.message.ExchangeMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collections;
import java.util.List;

/**
 * DESCRIPTION:
 *
 * @author:Jimmy.zhang
 */
public class ChatService {

    public static int getLastestReadedMessageSeq(String sessionId, String userId) {
        return NumberUtils.toInt(RedisClient.get(Constants.CACHE_KEY_SESSION_LASTEST_READ + userId + "_" + sessionId));
    }

    public static int sendChatMessage(List<ExchangeMessage.ChatMessage> chatMessages) {
        return 0;
    }

    private static boolean sendPrivateChat(ExchangeMessage.ChatMessage chatMessage) {

        return true;
    }

    private static boolean sendGroupChat(ExchangeMessage.ChatMessage chatMessage) {
        return true;
    }

    public static List<ExchangeMessage.ChatMessage> getAllUnreadMessage(String sessionId) {
        if (StringUtils.isBlank(sessionId)) {

        } else {

        }
        return Collections.EMPTY_LIST;
    }
}
