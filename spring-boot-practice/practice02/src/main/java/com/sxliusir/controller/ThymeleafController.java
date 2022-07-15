package com.sxliusir.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model){
        model.addAttribute("msg","<b>Hello</b>");
        HttpSession session = request.getSession(true);
        return "login";
    }

    @RequestMapping("online")
    @ResponseBody
    public String online(){
        return "当前在线人数："+MyHttpSessionListener.online +"人";
    }

    @RequestMapping("thymeleaf")
    public String thymeleaf(HttpServletRequest request, ModelMap map){
        HttpSession session = request.getSession(true);
        session.setAttribute("user","zhangsan");
        map.put("thText","th:text设置文本内容 <b>加粗</b>");
        map.put("thUText","th:utext 设置文本内容 <b>加粗</b>");
        map.put("thValue","thValue 设置当前元素的value值");
        map.put("thEach","Arrays.asList(\"th:each\", \"遍历列表\")");
        map.put("thIf","msg is not null");
        map.put("thObject",new Person("zhangsan",12,"男"));
        return "thymeleaf";
    }


    @RequestMapping("standardExpression")
    public String standardExpression(ModelMap map){
        map.put("Str", "Blog");
        map.put("Bool", true);
        map.put("Array", new Integer[]{1,2,3,4});
        map.put("List", Arrays.asList(1,3,2,4,0));
        Map hashMap = new HashMap();
        hashMap.put("thName", "${#...}");
        hashMap.put("desc", "变量表达式内置方法");
        map.put("Map", hashMap);
        map.put("Date", new Date());
        map.put("Num", 888.888D);
        return "standardExpression";
    }

    @RequestMapping("fragment")
    public String fragment() {
        //代码块
        return "fragment";
    }
}