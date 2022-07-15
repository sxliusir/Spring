package com.sxliusir.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyBean implements ApplicationRunner {
    @Autowired
    //java -jar **.jar --debug logfile.txt
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("----访问应用程序参数-----------");
        System.out.println(debug);
        System.out.println(nonOptionArgs);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("进行初始化操作");
    }
}
