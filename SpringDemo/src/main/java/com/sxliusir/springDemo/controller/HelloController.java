package com.sxliusir.springDemo.controller;

import com.sxliusir.springDemo.domain.City;
import com.sxliusir.springDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    CityService citySer;

    @RequestMapping("/hello")
    public String show1(ModelMap model){
        //static Map<Integer, City>  dataMap = Collections.synchronizedMap(new HashMap<Integer, City>());
        model.addAttribute("msg", "Hello, Thymeleaf!");
        return "hello2";
    }

    @RequestMapping("/list")
    public String list(ModelMap model) {
        List<City> list = citySer.getAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/addPage")
    public String addPage(ModelMap model) {
        return "add";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute City city, ModelMap model) {
        System.out.println(city);
        String status = citySer.save(city);
        model.addAttribute("success", status);
        return "add";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable Integer id) {
        System.out.println(id);
        citySer.del(id);
        return "list";
    }

}
