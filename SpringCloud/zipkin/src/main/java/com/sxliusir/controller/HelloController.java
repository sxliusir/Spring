package com.sxliusir.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @GetMapping("/hi")
    public String Hi()
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.baidu.com/";
        String str = restTemplate.getForObject(url, String.class);
        System.out.println(str);
        return str;
    }

}
