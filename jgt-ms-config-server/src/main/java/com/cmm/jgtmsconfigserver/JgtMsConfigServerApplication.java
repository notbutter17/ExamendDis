package com.cmm.jgtmsconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer

@SpringBootApplication
public class JgtMsConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgtMsConfigServerApplication.class, args);
    }

}
