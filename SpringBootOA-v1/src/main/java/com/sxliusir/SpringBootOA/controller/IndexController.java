package com.sxliusir.SpringBootOA.controller;

import com.sxliusir.SpringBootOA.mapper.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @GetMapping("/index/")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        User user = (User) request.getSession().getAttribute("userInfo");
        modelMap.addAttribute("user", user);
        return "backend/index";
    }
}
