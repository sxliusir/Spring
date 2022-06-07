package com.sxliusir.spring.mvc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {

    @Value("张三")
    private String loginName;
    @Value("123456")
    private String password;
    @Autowired
    private Pet pet;
}
