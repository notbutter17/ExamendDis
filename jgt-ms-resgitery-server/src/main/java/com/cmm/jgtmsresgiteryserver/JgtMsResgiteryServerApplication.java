package com.cmm.jgtmsresgiteryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer

@SpringBootApplication
public class JgtMsResgiteryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgtMsResgiteryServerApplication.class, args);
    }

}
