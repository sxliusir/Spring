package com.sxliusir.SpringBootOA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        Object username = request.getSession().getAttribute("userName");
        if (username == null) {
            return "redirect:/login";
        }
        modelMap.addAttribute("username", username);
        return "backend/index";
    }
}
