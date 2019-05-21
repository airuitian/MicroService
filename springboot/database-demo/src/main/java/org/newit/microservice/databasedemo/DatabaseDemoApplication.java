package org.newit.microservice.databasedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "org.newit.microservice.databasedemo.dao.*")
public class DatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

}
