package com.cloud;

import com.netflix.discovery.shared.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class EurekaJavaClient {

    public static void main(String[] args) {
        //new SpringApplicationBuilder(EurekaJavaClient.class).web(WebApplicationType.SERVLET).run(args);
        SpringApplication.run(EurekaJavaClient.class, args);
    }

}