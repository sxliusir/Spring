package com.sxliusir;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = PublisherApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class PublisherApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    void contextLoads() {
        for (int i = 0; i < 10000; i++) {
            amqpTemplate.convertAndSend("myqueue", "test" + i);
        }
        System.out.println("发送成功");
    }

}
