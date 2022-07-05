package com.sxliusir.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class TestController {
    @GetMapping("/test")
    public String name() {
        return "this is from client-2";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return "my name is lilei.(from client-2)";
    }
}
