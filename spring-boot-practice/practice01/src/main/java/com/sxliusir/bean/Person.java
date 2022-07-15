package com.sxliusir.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private String age;

    private String sex;

    @Value("${person.desc}")
    private String desc;

    public Person() {
    }

    public Person(String name, String age, String sex, String desc) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
