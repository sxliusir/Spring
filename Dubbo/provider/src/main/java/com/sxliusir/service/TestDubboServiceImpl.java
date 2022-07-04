package com.sxliusir.service;


import com.alibaba.dubbo.config.annotation.Service;

@Service(version="1.0.0")
public class TestDubboServiceImpl implements TestDubboService{
    @Override
    public void toProvider() {
        System.out.println("恭喜！");
    }
}
