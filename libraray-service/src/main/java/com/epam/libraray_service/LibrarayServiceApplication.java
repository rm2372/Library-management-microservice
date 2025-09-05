package com.epam.libraray_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibrarayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarayServiceApplication.class, args);
	}

}
