package me.nuzzle.base;

import me.nuzzle.base.libs.Configure;
import me.nuzzle.base.server.HttpServer;
import me.nuzzle.base.server.TcpServer;
import me.nuzzle.base.services.ServerChannelRouter;

/**
 * DESCRIPTION:
 *
 * @author:Jimmy.zhang
 */
public class ServerBootstrap {

    public static void main(String[] args) throws Exception {
        startTcpServer();
        startHttpServer();
    }

    private static void startTcpServer() throws Exception {
        int port = Configure.getInteger("tcp.port", 45678);

        TcpServer tcpServer = new TcpServer(port);
        tcpServer.listen();

        //TODO get self internet ip
        ServerChannelRouter.registerServer("127.0.0.1");
    }

    private static void startHttpServer() throws Exception {
        HttpServer.listen();
    }
}
