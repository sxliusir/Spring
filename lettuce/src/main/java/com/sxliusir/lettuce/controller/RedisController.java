package com.sxliusir.lettuce.controller;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {
    @GetMapping("/redis")
    @ResponseBody
    public String redis(){
        RedisClient client = RedisClient.create("redis://localhost:6379");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStringCommands sync = connection.sync();
        Object key = sync.get("test");
        System.out.println(key);
        return "";
    }
}
