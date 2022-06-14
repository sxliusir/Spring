package com.sxliusir.SpringBootOA.controller;

import com.sxliusir.SpringBootOA.entity.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    Sys sys;

    /**
     * 个人信息
     * @return
     */
    @GetMapping("/profile")
    public String profile() {
        System.out.println(sys.getSystemName());
        return "/backend/user/profile";
    }

    @PostMapping("/saveProfile")
    @ResponseBody
    public String saveProfile() {
        return "ok";
    }

    /**
     * 修改密码
     * @return
     */
    @GetMapping("/editPwd")
    public String editPwd() {
        return "/backend/user/editPwd";
    }

    @PostMapping("/savePwd")
    @ResponseBody
    public String savePwd() {
        return "ok";
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        sessoin.invalidate();
        return "redirect:/login";
    }
}
