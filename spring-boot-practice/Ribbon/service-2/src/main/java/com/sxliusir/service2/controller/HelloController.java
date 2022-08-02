package com.sxliusir.service2.controller;

import com.sxliusir.service2.dto.HouseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return new HouseInfo(1L, "山西", "太原", "林业厅");
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return name;
    }

    @PostMapping("/house/save")
    public Long addData(@RequestBody HouseInfo houseInfo) {
        System.out.println(houseInfo.getName());
        System.out.println(houseInfo.getCity());
        return 1001L;
    }
}
