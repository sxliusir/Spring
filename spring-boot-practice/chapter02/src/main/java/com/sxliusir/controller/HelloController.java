package com.sxliusir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //注入配置
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private Environment env;

    @GetMapping("/hello")
    public String hello() {
        //读取配置文件
        String port = env.getProperty("server.port");
        System.out.println("server port:" + serverPort);
        return port;
    }
}
