package com.sxliusir.SpringBootOA.controller;

import com.sxliusir.SpringBootOA.entity.Sys;
import com.sxliusir.SpringBootOA.mapper.User;
import com.sxliusir.SpringBootOA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    Sys sys;

    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login/")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("systemName", sys.getSystemName());
        return "login/login";
    }

    @PostMapping("/login/")
    @ResponseBody
    public String userLogin(@ModelAttribute User user) {
        String status = userService.login(user);
        return status;
    }
}