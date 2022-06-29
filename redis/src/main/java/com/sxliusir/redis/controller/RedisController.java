package com.sxliusir.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RedisController {
    @Autowired
    private RedisTemplate<String, String> template;


    @GetMapping("/redis")
    @ResponseBody
    public String redis()
    {
        //get set demo
        /*
        ValueOperations<String, String> values = template.opsForValue();
        values.set("01", "Joe");
        values.set("02", "John");

        System.out.println("Employee added: " + values.get("01"));
        System.out.println("Employee added: " + values.get("02"));
        */

        //hash
        HashOperations<String, String, String> hash = template.opsForHash();
        String empJoeKey = "emp:joe";
        String empJohnKey = "emp:john";

        Map<String, String> empJoeMap = new HashMap<>();
        empJoeMap.put("name", "Joe");
        empJoeMap.put("age", "32");
        empJoeMap.put("id", "01");

        Map<String, String> empJohnMap = new HashMap<>();
        empJohnMap.put("name", "John");
        empJohnMap.put("age", "42");
        empJohnMap.put("id", "02");

        hash.putAll(empJoeKey, empJoeMap);
        hash.putAll(empJohnKey, empJohnMap);

        System.out.println("Get emp joe details: " + hash.entries(empJoeKey));
        System.out.println("Get emp john details: " + hash.entries(empJohnKey));

        return "";
    }
}
