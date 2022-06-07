package com.sxliusir.spring;

import com.sxliusir.spring.lazyInit.A;
import com.sxliusir.spring.lazyInit.B;
import com.sxliusir.spring.mvc.controller.MainController;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestGetBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Person person = ctx.getBean("person", Person.class);
        //System.out.println(ToStringBuilder.reflectionToString(person));
//        Car car = ctx.getBean("car", Car.class);
//        System.out.println(car.getName());
//        System.out.println(car.getPrice());

        //lazy-init test
//        A a = ctx.getBean("A", A.class);
//        System.out.println("a的值"+a.getName());
//        //System.out.println(a.getB());
//
//        B b = ctx.getBean("B", B.class);
//        System.out.println(b.getName());

        //mvc test
        MainController mainController = ctx.getBean("mainController", MainController.class);
        mainController.list();
    }
}
