package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaMessyClient {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMessyClient.class, args);
    }
}