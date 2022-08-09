package com.sxliusir;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DemoReceive {

    @RabbitListener(queues = "myqueue")
    public void demo(String msg){
        System.out.println("获取到的消息："+msg);
    }

//    @RabbitListener(queues = "myqueue")
//    public void demo2(String msg){
//        System.out.println("获取到的消息2222："+msg);
//    }
}