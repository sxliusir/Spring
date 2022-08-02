package com.sxliusir;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-provider", configuration = FeignAuthConfiguration.class)
public interface UserConsumerService extends RegisterApi {

}

