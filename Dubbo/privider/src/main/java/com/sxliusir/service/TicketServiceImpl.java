package com.sxliusir.service;

// zookeeper： 服务注册和发现

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // dubbo的注解，可以被扫描到，在项目一启动就自动注册到注册中心
@Component
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "一张电影票";
    }
}