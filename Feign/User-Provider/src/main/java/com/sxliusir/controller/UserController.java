package com.sxliusir.controller;

import com.sxliusir.RegisterApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements RegisterApi {

    @Override
    public String isAlive() {
        return "ok";
    }
}
