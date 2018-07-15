package com.xuexiang.xhttpapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xuexiang.xhttpapi.mapper")
public class XHttpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(XHttpApiApplication.class, args);
	}
}
