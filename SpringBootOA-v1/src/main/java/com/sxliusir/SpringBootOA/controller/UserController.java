package com.sxliusir.SpringBootOA.controller;

import com.github.pagehelper.PageInfo;
import com.sxliusir.SpringBootOA.entity.Sys;
import com.sxliusir.SpringBootOA.mapper.User;
import com.sxliusir.SpringBootOA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    Sys sys;

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @return
     */
    @GetMapping("/add/")
    public String add(ModelMap modelMap, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("userInfo");
        modelMap.addAttribute("user", user);
        return "backend/user/add";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/del/")
    @ResponseBody
    public String remove(@RequestParam int id) {
        return userService.remove(id);
    }

//    /**
//     * 编辑页面
//     * @param id
//     * @param modelMap
//     * @return
//     */
//    @RequestMapping("/edit/{id}/")
//    public String edit(@PathVariable Integer id, ModelMap modelMap) {
//        User user = userService.getOne(id);
//        modelMap.addAttribute("user", user);
//        return "edit";
//    }
//
//    /**
//     * 编辑保存
//     * @param user
//     * @return
//     */
//    @PostMapping("/save")
//    public String save(@ModelAttribute User user) {
//        userService.save(user);
//        return "redirect:/list";
//    }
//

    /**
     * 分页
     * @param modelMap
     * @return
     */
    @GetMapping("/list/")
    public String list(ModelMap modelMap, @RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "10" ) int pageSize, HttpServletRequest request) {
        PageInfo<User> list = userService.findByPage(pageNum, pageSize);
        User user = (User) request.getSession().getAttribute("userInfo");
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("list", list);
        return "backend/user/list";
    }

    /**
     * 个人信息
     * @return
     */
    @GetMapping("/profile/")
    public String profile(ModelMap modelMap, HttpServletRequest request) {
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        if (null != userInfo.getId()) {
            User user = userService.findOne(userInfo.getId());
            if (null != user) {
                modelMap.addAttribute("user", user);
                return "backend/user/profile";
            }
            return "redirect:/login/";
        }
        return "redirect:/login/";
    }

    @PostMapping("/saveProfile")
    @ResponseBody
    public String saveProfile(@RequestBody(required = false) Map<String, String> map) {
        //System.out.println("map:" + map);
        return userService.save(map);
    }

    /**
     * 修改密码
     * @return
     */
    @GetMapping("/editPwd/")
    public String editPwd() {
        return "backend/user/editPwd";
    }

    @PostMapping("/savePwd/")
    @ResponseBody
    public String savePwd() {
        return "ok";
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout/")
    public String logout(HttpServletRequest request) {
        HttpSession sessoin = request.getSession();
        sessoin.invalidate();
        return "redirect:/login/";
    }
}
