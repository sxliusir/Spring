package com.sxliusir.spring.mvc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pet {
    @Value("旺财")
    private String name;
}
