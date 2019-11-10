package com.yyh.tdhy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yyh.tdhy.mapper")
public class TdhyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TdhyApplication.class, args);
	}

}
