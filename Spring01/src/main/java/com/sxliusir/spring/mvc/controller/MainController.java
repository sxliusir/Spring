package com.sxliusir.spring.mvc.controller;

import com.sxliusir.spring.mvc.entity.User;
import com.sxliusir.spring.mvc.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("mainController")
public class MainController {

    @Autowired
    private MainService service;

    public String list() {
        String loginName = "zhangfg";
        String password = "123456";
        User login = service.login(loginName, password);
        if (login == null) {
            return "登录失败";
        } else {
            return "登录成功";
        }
    }
}
