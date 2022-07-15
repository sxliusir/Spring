package com.sxliusir.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class Employee {
    //@RequestMapping(value = "/employees", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
    @RequestMapping("/employees")
    @ResponseBody
    public void getAllEmployeesHtml(Model model)
    {
        System.out.println("dddd");
//        ArrayList<String> sites = new ArrayList<String>();
//        sites.add("Google");
//        sites.add("Runoob");
//        sites.add("Taobao");
//        sites.add("Weibo");
//        model.addAttribute("web", sites);
        //return "employees";
    }
}
