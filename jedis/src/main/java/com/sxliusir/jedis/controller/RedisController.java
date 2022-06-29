package com.sxliusir.jedis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class RedisController {
    @GetMapping("/redis")
    @ResponseBody
    public String redis() {
        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedis = pool.getResource()) {
            jedis.hset("tom","age", "18");
            jedis.hset("tom", "from", "北京");
            String test = jedis.get("test");
            System.out.println(test);
        }
        return "";
    }
}
