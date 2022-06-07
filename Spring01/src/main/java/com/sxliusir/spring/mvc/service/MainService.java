package com.sxliusir.spring.mvc.service;

import com.sxliusir.spring.mvc.dao.UserDao;
import com.sxliusir.spring.mvc.entity.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    @Autowired
    @Qualifier("daoMysql")
    UserDao dao;

    public User login(String loginName, String password) {
        System.out.println("loginName:" + loginName);
        System.out.println("Service 接到请求 ，开始处理");
        User user = dao.getUserByName(loginName);
        System.out.println(ToStringBuilder.reflectionToString(user));
        return user;
    }
}
