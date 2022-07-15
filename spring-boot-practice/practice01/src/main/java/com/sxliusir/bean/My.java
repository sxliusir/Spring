package com.sxliusir.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class My {
    @Value("${my.secret}")
    private String screct;
    @Value("${my.number}")
    private int number;
    @Value("${my.bignumber}")
    private long bignumber;
    @Value("${my.uuid}")
    private UUID uuid;
    @Value("${my.number.less.than.ten}")
    private int lessThanTen;
    @Value("${my.number.in.range}")
    private int numberInRangel;

    @Override
    public String toString() {
        return "My{" +
                "screct='" + screct + '\'' +
                ", number=" + number +
                ", bignumber=" + bignumber +
                ", uuid=" + uuid +
                ", lessThanTen=" + lessThanTen +
                ", numberInRangel=" + numberInRangel +
                '}';
    }
}
