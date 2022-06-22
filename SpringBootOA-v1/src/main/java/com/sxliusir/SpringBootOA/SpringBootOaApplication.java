package com.sxliusir.SpringBootOA;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.sxliusir.SpringBootOA.mapper")
@EnableSwagger2Doc
public class SpringBootOaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOaApplication.class, args);
	}

}
