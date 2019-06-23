package com.github.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String helloworld() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "hello,world!";
    }
}
