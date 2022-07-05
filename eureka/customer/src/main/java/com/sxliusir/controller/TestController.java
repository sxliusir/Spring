package com.sxliusir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/customer")
public class TestController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String name() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://eureka-client/client/test", String.class);
        return entity.getBody();
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://eureka-client/client/getUserInfo", String.class);
        return entity.getBody();
    }
}
