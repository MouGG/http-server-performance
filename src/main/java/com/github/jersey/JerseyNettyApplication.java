package com.github.jersey;

import io.netty.channel.Channel;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class JerseyNettyApplication {

    public static final URI BASE_URI = UriBuilder.fromUri("http://localhost/").port(8080).build();

    public static void main(String[] args) {
        Channel server = startServer();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> server.close()));
    }

    public static Channel startServer() {
        ResourceConfig resourceConfig = new ResourceConfig().packages("com.github");
        return NettyHttpContainerProvider.createHttp2Server(BASE_URI, resourceConfig, null);
    }
}
