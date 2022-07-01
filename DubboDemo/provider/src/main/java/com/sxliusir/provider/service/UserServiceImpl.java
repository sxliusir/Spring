package com.sxliusir.provider.service;

import com.sxliusir.api.UserService;
import com.sxliusir.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0")
@Component
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserInfo(long userId) {
        log.debug("我是service下的debug");
//        log.info("request from consumer: {}", RpcContext.getContext().getRemoteAddress());
//        log.info("response from provider: {}" , RpcContext.getContext().getLocalAddress());
        return new User(userId, "userName" + userId , " --->>>>response from remote RPC provider:");
    }
}
