package com.sxliusir.service;

import org.springframework.stereotype.Component;

@Component
public class HelloFallbackImpl implements HelloService {
    @Override
    public String hi() {
        return "远程服务不可用，请稍后重试。。。。。";
    }

    @Override
    public String hiWithTimeOut() {
        return "请求超时。";
    }
}