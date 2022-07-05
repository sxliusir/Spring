package com.sxliusir.controller;

import com.sxliusir.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    // 想拿到 provide-server 的提供的类, 就要去注册中心拿到服务
    // 动态接口实现
    @Reference
    TicketService ticketService;

    @GetMapping("/getTicket")
    public String buyTicket() {
        String ticket = ticketService.getTicket();
        return "在注册中心拿到 =>" + ticket;
    }
}
