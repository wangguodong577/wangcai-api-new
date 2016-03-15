package me.nuzzle.base.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import me.nuzzle.base.common.Constants;
import me.nuzzle.base.libs.EasyMap;
import me.nuzzle.base.message.ExchangeMessage;
import me.nuzzle.base.services.ChatService;
import me.nuzzle.base.services.ServerChannelRouter;
import me.nuzzle.base.services.UserService;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理来自客户端的消息
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<ExchangeMessage.Message> {

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ServerChannelRouter.remove((SocketChannel) ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (7)
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "异常");
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
        ServerChannelRouter.remove((SocketChannel) ctx.channel());
    }

    private void err(ExchangeMessage.Message requestMessage, Channel channel, String errcode) {
        ExchangeMessage.Body body = ExchangeMessage.Body.newBuilder()
                .setErrcode(errcode)
                .setRet(500)
                .build();
        ExchangeMessage.Message message = ExchangeMessage.Message.newBuilder()
                .setMsgid(requestMessage.getMsgid())
                .setToken(requestMessage.getToken())
                .setType(ExchangeMessage.Message.MessageType.ACK)
                .setBody(body)
                .build();
        channel.writeAndFlush(message);
    }

    private void ok(ExchangeMessage.Message requestMessage, Channel channel, Object obj) {
        String data = "{}";
        try {
            data = new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
        }
        ExchangeMessage.Body body = ExchangeMessage.Body.newBuilder()
                .setData(data)
                .setRet(200)
                .build();
        ExchangeMessage.Message message = ExchangeMessage.Message.newBuilder()
                .setMsgid(requestMessage.getMsgid())
                .setToken(requestMessage.getToken())
                .setType(ExchangeMessage.Message.MessageType.ACK)
                .setBody(body)
                .build();
        channel.writeAndFlush(message);
    }

    private void chat(ExchangeMessage.Message requestMessage, Channel channel, List<ExchangeMessage.ChatMessage> chatMessages) {
        ExchangeMessage.Message message = ExchangeMessage.Message.newBuilder()
                .setMsgid(requestMessage.getMsgid())
                .setToken(requestMessage.getToken())
                .setType(ExchangeMessage.Message.MessageType.CHAT)
                .addAllChatMessage(chatMessages)
                .build();
        channel.writeAndFlush(message);
    }

    private Map getParams(String params) {
        if (StringUtils.isBlank(params)) {
            return Collections.EMPTY_MAP;
        }
        try {
            String[] kvs = params.split("&");
            Map<String, String> paramMap = new HashMap<>();
            for (String kv : kvs) {
                String[] ps = kv.split("=");
                paramMap.put(ps[0], ps[1]);
            }
            return paramMap;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ExchangeMessage.Message message) throws Exception {
        Channel channel = channelHandlerContext.channel();
        String userId = UserService.getUserIdFromToken(message.getToken());
        if (StringUtils.isBlank(userId)) {
            err(message, channel, Constants.ERR_NOT_LOGIN);
            channel.closeFuture();
            return;
        } else {
            ServerChannelRouter.add(userId, (SocketChannel) channel);
            switch (message.getType()) {
                case ACK:
                    ok(message, channel, new EasyMap("result", true).easyPut("userId", userId));
                    break;
                case PING:
                    ok(message, channel, new EasyMap("result", true).easyPut("userId", userId));
                    break;
                case CHAT: {
                    if (message.getChatMessageCount() == 0) {
                        err(message, channel, Constants.ERR_PARAM_ERROR);
                    } else {
                        List<ExchangeMessage.ChatMessage> chatMessages = message.getChatMessageList();
                        int result = ChatService.sendChatMessage(chatMessages);
                        if (result > 0) {
                            ok(message, channel, new EasyMap("result", result));
                        } else {
                            err(message, channel, Constants.ERR_SERVER_ERROR);
                        }
                    }
                }
                case RPC: {
                    if (message.hasBody() && message.getBody().hasAction()) {
                        ExchangeMessage.Body body = message.getBody();
                        String action = body.getAction();
                        if ("GetAllUnReadMessage".equals(action)) {
                            Map<String, String> params = getParams(body.getParams());
                            if (params == null) {
                                err(message, channel, Constants.ERR_PARAM_ERROR);
                            } else {
                                List<ExchangeMessage.ChatMessage> chatMessages = ChatService.getAllUnreadMessage(params.get("sessionId"));
                                chat(message, channel, chatMessages);
                            }
                        } else {
                            err(message, channel, Constants.ERR_PARAM_ERROR);
                        }
                    } else {
                        err(message, channel, Constants.ERR_PARAM_ERROR);
                    }
                }
                break;
                default:
                    if (ServerChannelRouter.get(userId) == null) {
                        err(message, channel, Constants.ERR_NOT_LOGIN);
                    }
            }
        }
        ReferenceCountUtil.release(message);
    }


}
