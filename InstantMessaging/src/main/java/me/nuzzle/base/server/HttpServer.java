package me.nuzzle.base.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import me.nuzzle.base.libs.Configure;
import org.apache.commons.lang3.StringUtils;

/**
 * DESCRIPTION:
 *
 * @author:Jimmy.zhang
 */
public class HttpServer {

    static final boolean SSL = StringUtils.equals(Configure.getString("http.ssl"), "true");
    static final int PORT = SSL ? Configure.getInteger("http.ssl.port", 8443) : Configure.getInteger("http.port", 8080);

    public static void listen() throws Exception {
        // Configure SSL.
        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
        } else {
            sslCtx = null;
        }
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            if (sslCtx != null) {
                                p.addLast(sslCtx.newHandler(socketChannel.alloc()));
                            }
                            p.addLast(new HttpRequestDecoder());
                            // Uncomment the following line if you don't want to handle HttpChunks.
                            //p.addLast(new HttpObjectAggregator(1048576));
                            p.addLast(new HttpResponseEncoder());
                            // Remove the following line if you don't want automatic content compression.
                            //p.addLast(new HttpContentCompressor());
                            p.addLast(new HttpServerHandler());
                        }
                    });
            Channel ch = b.bind(PORT).sync().channel();
            System.err.println("Open your web browser and navigate to " +
                    (SSL ? "https" : "http") + "://127.0.0.1:" + PORT + '/');
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
