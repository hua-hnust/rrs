package com.xhua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.xhua.dao")
public class RrsApplication {
	public static void main(String[] args) {
		SpringApplication.run(RrsApplication.class, args);
	}

}
