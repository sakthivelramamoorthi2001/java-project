package com.example.CRUD;

import org.mapstruct.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication()
//@ComponentScan(basePackages = "com.example.CRUD")
public class CrudApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudApplication.class, args);
	}

}
