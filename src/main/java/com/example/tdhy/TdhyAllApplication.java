package com.example.tdhy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.tdhy.mapper")
@ComponentScan(basePackages = {})
public class TdhyAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdhyAllApplication.class, args);
	}

}
