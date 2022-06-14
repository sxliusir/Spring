package com.sxliusir.SpringBootOA;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.sxliusir.SpringBootOA.mapper")
public class SpringBootOaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOaApplication.class, args);
	}

}
