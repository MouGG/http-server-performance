package com.github.jooby;

import org.jooby.Jooby;

import java.util.concurrent.TimeUnit;

public class JoobyApplication extends Jooby {

    {
        get("/", () -> {
            TimeUnit.SECONDS.sleep(1);
            return "hello,world!";
        });
    }

    public static void main(final String[] args) {
        run(JoobyApplication::new, args);
    }
}
