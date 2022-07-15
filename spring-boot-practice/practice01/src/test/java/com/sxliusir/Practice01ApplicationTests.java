package com.sxliusir;

import com.sxliusir.bean.My;
import com.sxliusir.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Practice01ApplicationTests {

    @Autowired
    Person person;

    @Autowired
    My my;

    @Test
    void contextLoads() {
        System.out.println(person);
        System.out.println(my);
    }
}
