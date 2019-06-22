package com.github.resteasy;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ResteasyApplication {
    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8080;
        ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplication(new Application() {
            @Override
            public Set<Class<?>> getClasses() {
                HashSet<Class<?>> classes = new HashSet<>();
                classes.add(HelloResource.class);
                return classes;
            }
        });
        NettyJaxrsServer netty = new NettyJaxrsServer();
        netty.setDeployment(deployment);
        netty.setHostname(host);
        netty.setPort(port);
        netty.setRootResourcePath("/");
        netty.setSecurityDomain(null);
        netty.start();
    }
}
