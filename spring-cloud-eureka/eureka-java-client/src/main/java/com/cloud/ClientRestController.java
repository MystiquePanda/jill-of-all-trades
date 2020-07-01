package com.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientRestController {
    
    @RequestMapping("/test")
    public String TestEndPoint (){
        return "test";
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }
}