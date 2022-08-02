package com.sxliusir.controller;

import com.sxliusir.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {
    @Resource
    HelloService helloService;

    @GetMapping("hi")
    public String hi(){
        return helloService.hi();
    }

    @GetMapping("hiWithTimeOut")
    public String hiWithTimeOut(){
        return helloService.hiWithTimeOut();
    }
}