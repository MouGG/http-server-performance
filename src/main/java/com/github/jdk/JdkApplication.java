package com.github.jdk;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JdkApplication {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        httpServer.createContext("/hello", new HelloHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }
}
