package com.sxliusir;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户操作相关接口
 * @author 一明哥
 *
 */
//
public interface RegisterApi {

    @GetMapping("/User/isAlive")
    public String isAlive();
}
