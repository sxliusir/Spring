package com.sxliusir.servicenacos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 下单
     * @return
     */
    @RequestMapping("/add")
    public String addOrder(){
        System.out.println("下单成功");

        return "订单服务";
    }
}