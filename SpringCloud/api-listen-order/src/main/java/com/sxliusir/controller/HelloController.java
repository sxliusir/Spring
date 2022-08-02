package com.sxliusir.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${server.port}")
    String port;

    @GetMapping("hi")
    public String hi(){
        // 通过返回port，使掉用端方便查看调用的是那个端口的服务
        return "hi~ my port ===" + port;
    }
    // 测试服务调用超时
    @GetMapping("hiWithTimeOut")
    public String hiWithTimeOut() throws InterruptedException {
        Thread.sleep(10000);
        return "hi~ my port ===" + port;
    }
}
