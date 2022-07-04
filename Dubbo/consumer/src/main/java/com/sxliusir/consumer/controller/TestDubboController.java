package com.sxliusir.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sxliusir.service.TestDubboService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class TestDubboController {

    @Reference(version = "1.0.0")//该注解的作用就是订阅服务
    private TestDubboService testServices;

    @RequestMapping("/testDubbo")
    public void testDubbo() throws Exception {
        testServices.toProvider();
    }

}