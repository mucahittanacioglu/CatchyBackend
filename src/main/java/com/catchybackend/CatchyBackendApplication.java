package com.catchybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.ts.core","com.catchybackend"})
public class CatchyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatchyBackendApplication.class, args);
    }

}
