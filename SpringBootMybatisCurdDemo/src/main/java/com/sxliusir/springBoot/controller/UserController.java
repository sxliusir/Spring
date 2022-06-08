package com.sxliusir.springboot.controller;

import com.sxliusir.springboot.mapper.User;
import com.sxliusir.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public void list() {
        List<User> list = userService.findAll();
        System.out.println("s");
    }
}
