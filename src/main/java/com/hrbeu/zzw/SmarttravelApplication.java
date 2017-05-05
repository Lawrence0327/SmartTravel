package com.hrbeu.zzw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.hrbeu.zzw.dao")
@SpringBootApplication
public class SmarttravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarttravelApplication.class, args);
	}
}
