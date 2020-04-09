package com.czp.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.czp.project.dao") // 自动注入dao层对象
public class OmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmProjectApplication.class, args);
	}

}
