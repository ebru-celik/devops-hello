package com.ebru.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

// http://localhost:8080
@RestController
public class DevopsController {

    @GetMapping
    String getDevopsHello(){

        LocalDateTime mytime = LocalDateTime.now();
        System.out.println(mytime);

        return "DevOps Pipline Hello: " +mytime;
    }

    @GetMapping("/info")
    String getDevopsInfo(){

        LocalDateTime mytime = LocalDateTime.now();
        System.out.println(mytime);

        return "Info: DevOps Pipline Info: " +mytime;
    }
}
