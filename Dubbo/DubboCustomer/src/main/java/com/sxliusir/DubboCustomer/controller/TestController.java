package com.sxliusir.DubboCustomer.controller;

import com.sxliusir.DubboCustomer.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.dubbo.config.annotation.Reference;

@Controller
public class TestController {
    @Reference(version = "1.0.0")
    DemoService serv;

    @RequestMapping("/test")
    public void test() {
        String tom = serv.sayHello("Tom");
        System.out.println(tom);
    }
}
