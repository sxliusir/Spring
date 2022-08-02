package com.sxliusir.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api-listen-order",fallbackFactory = HelloFallbackFactory.class)
public interface HelloService {
    @GetMapping("hi")
    String hi();

    @GetMapping("hiWithTimeOut")
    String hiWithTimeOut();
}