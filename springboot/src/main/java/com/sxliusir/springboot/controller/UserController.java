package com.sxliusir.springboot.controller;


import com.sxliusir.springboot.mapper.User;
import com.sxliusir.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 注册页面
     * @return
     */
    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public String add(@ModelAttribute User user) {
        userService.reg(user);
        return "redirect:/list";
    }

    /**
     * 用户列表
     * @param modelMap
     * @return
     */
    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        List<User> list = userService.findAll();
        modelMap.addAttribute("list", list);
        return "list";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}/")
    public String remove(@PathVariable Integer id) {
        userService.remove(id);
        return "redirect:/list";
    }

    /**
     * 编辑页面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/edit/{id}/")
    public String edit(@PathVariable Integer id, ModelMap modelMap) {
        User user = userService.getOne(id);
        modelMap.addAttribute("user", user);
        return "edit";
    }

    /**
     * 编辑保存
     * @param user
     * @return
     */
    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/view/{id}/")
    public String view(@PathVariable Integer id, ModelMap modelMap) {
        User user = userService.getOne(id);
        System.out.println(user);
        modelMap.addAttribute("user", user);
        return "view";
    }
}
