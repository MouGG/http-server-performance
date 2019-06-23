package com.github.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greeting() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "hello,world!";
    }
}
