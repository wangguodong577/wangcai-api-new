package me.nuzzle.base.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import me.nuzzle.base.message.ExchangeMessage;

/**
 * DESCRIPTION:
 *
 * @author:Jimmy.zhang
 */
public class TcpServer {
    private int port;

    public TcpServer(int port) throws InterruptedException {
        this.port = port;
    }

    public void listen() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG, 128);
            bootstrap.option(ChannelOption.TCP_NODELAY, true);
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline cp = socketChannel.pipeline();
                    cp.addLast("protobufEncoder", new ProtobufEncoder());
                    cp.addLast("protobufDecoder", new ProtobufDecoder(ExchangeMessage.Message.getDefaultInstance()));
                    cp.addLast(new TcpServerHandler());
                }
            });

            ChannelFuture f = bootstrap.bind(port).sync();
            if (f.isSuccess()) {
                System.out.println("---Netty Server has Started---");
            }
        } finally {
//            boss.shutdownGracefully();
//            worker.shutdownGracefully();
        }
    }
}
