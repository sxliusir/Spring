package com.sxliusir.DubboProvider.service;

import org.apache.dubbo.config.annotation.Service;

@Service
public interface DemoService {
    String sayHello(String name);
}
