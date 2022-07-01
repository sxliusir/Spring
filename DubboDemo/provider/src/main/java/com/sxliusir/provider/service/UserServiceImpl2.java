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
@Service("UserServiceImpl2")
public class UserServiceImpl2 implements UserService {

    /**
     *
     * @param userId
     * @return
     * RPC provider 接口 实现
     */
    @Override
    public User getUserInfo(long userId) {
        log.debug("我是service下的debug");
        log.info("request from consumer: {}");
        log.info("response from provider: {}");
        return new User(userId, "userName" + userId , " --->>>>response from remote RPC provider:");
    }

    /**
     *
     * @param userId
     * @return
     * 本地 provider 接口 实现
     */
    public User getUserInfoFromLocal(Long userId){
        return new User(userId,"userName"+userId," --->>>>from Local provider ");
    }

}