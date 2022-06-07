package com.sxliusir.SpringJpaDemo.controller;

import com.sxliusir.SpringJpaDemo.entity.City;
import com.sxliusir.SpringJpaDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    CityService cityService;
    @RequestMapping("/list")
    public String list(Model model) {
        List<City> list = cityService.findAll();
        model.addAttribute("list", list);
        return "list";
    }
}
