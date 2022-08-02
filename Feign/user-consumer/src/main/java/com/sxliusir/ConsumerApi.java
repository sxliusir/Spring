package com.sxliusir;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.Map;

@FeignClient(name = "user-provider")
public interface ConsumerApi extends RegisterApi{
    Map<Integer, String> getMap(Integer id);
}
