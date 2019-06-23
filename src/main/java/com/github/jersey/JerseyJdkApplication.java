package com.github.jersey;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class JerseyJdkApplication {

    public static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(8080).build();

    public static void main(String[] args) {
        HttpServer server = startServer();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.stop(0)));
    }

    public static HttpServer startServer() {
        ResourceConfig resourceConfig = new ResourceConfig().packages("com.github.jersey");
        return JdkHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);
    }
}
