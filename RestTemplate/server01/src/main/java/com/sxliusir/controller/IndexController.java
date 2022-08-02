package com.sxliusir.controller;

import com.sxliusir.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @GetMapping("/Hi")
    public String Hi(){
        return "Hi";
    }

    @GetMapping("/getMap")
    public Map<String,String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name","tom");
        return map;
    }

    @GetMapping("/getObj")
    public Person getObj() {
        Person person = new Person();
        person.setId(100);
        person.setName("tom");
        return person;
    }

    @GetMapping("/getObjParam")
    public Person getObjParam(@RequestParam("name") String name) {
        Person person = new Person();
        person.setId(001);
        person.setName(name);
        return person;
    }

    @PostMapping("/postParam")
    public Person postParam(@RequestBody String name) {

        System.out.println(name);
        Person person = new Person();
        person.setId(2);
        person.setName(name);
        return person;
    }
}
