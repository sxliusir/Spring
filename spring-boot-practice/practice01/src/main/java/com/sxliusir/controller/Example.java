package com.sxliusir.controller;

import com.sxliusir.Practice01Application;
import com.sxliusir.bean.MyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.Banner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@EnableAutoConfiguration
public class Example {
    @Autowired
    private Environment env;
    private static ConfigurableApplicationContext app;

    @RequestMapping("/")
    public String home() {
        //打印随机值
        System.out.println(env.getProperty("my.secret"));
        //打印属性
        System.out.println(env.getProperty("app.description"));
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);
//        SpringApplication app = new SpringApplication(Example.class);
//        //关闭 banner
////        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
        app = SpringApplication.run(Example.class, args);
    }

    @RequestMapping("/exit")
    public void exit(){
        if(null != app) {
            app.close();
            System.out.println("Spring Boot exit success.");
        } else {
            System.out.println("ConfigurableApplicationContext is null");
        }
    }

    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet());
        ArrayList<String> url = new ArrayList<>();
        url.add("/srv");
        bean.setUrlMappings(url);
        bean.setLoadOnStartup(1);
        return bean;
    }
}