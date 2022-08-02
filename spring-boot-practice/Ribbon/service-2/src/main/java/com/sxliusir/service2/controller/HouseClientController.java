package com.sxliusir.service2.controller;

import com.sxliusir.service2.dto.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HouseClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/datas")
    public HouseInfo getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://localhost:10002/data?name=" + name, HouseInfo.class);
    }

    @GetMapping("/datas/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:10002/data/{name}", String.class, name);
    }

    @GetMapping("/call/dataEntity")
    public HouseInfo getDataEntity(@RequestParam("name") String name) {
        ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity(
                "http://localhost:10002/data?name="+name, HouseInfo.class);
        if(responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }
    @GetMapping("/call/save")
    public Long add(){
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCity("北京");
        houseInfo.setRegion("昌平");
        houseInfo.setName("回龙观");
        Long aLong = restTemplate.postForObject("http://localhost:10002/house/save", houseInfo, Long.class);
        return aLong;
    }
}
