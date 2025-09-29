package com.cmm.jgtmsmatricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class JgtMsMatriculaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JgtMsMatriculaApplication.class, args);
    }

}
