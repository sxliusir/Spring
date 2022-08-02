package com.sxliusir.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloFallbackFactory implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String hi() {
                return "请求失败～ error msg：" + throwable.getMessage();
            }

            @Override
            public String hiWithTimeOut() {
                return "请求超时～ error msg：" + throwable.getMessage();
            }
        };
    }
}