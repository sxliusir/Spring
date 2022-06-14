package com.sxliusir.SpringBootOA.controller;

import com.github.pagehelper.PageInfo;
import com.sxliusir.SpringBootOA.entity.Sys;
import com.sxliusir.SpringBootOA.mapper.User;
import com.sxliusir.SpringBootOA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    Sys sys;

    @Autowired
    UserService userService;

    /**
     * 分页
     * @param modelMap
     * @return
     */
    @GetMapping("/list/")
    public String list(ModelMap modelMap, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10" ) int pageSize) {
        PageInfo<User> list = userService.findByPage(pageNum, pageSize);
        modelMap.addAttribute("list", list);
        return "/backend/user/list";
    }

    /**
     * 个人信息
     * @return
     */
    @GetMapping("/profile")
    public String profile(ModelMap modelMap, HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        if (null != userId) {
            User user = userService.findOne(userId);
            if (null != user) {
                modelMap.addAttribute("user", user);
                return "/backend/user/profile";
            }
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @PostMapping("/saveProfile")
    @ResponseBody
    public String saveProfile(@RequestBody(required = false) Map<String, String> map) {
        System.out.println("map:" + map);
        return userService.save(map);
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
