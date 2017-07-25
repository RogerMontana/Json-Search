package com.rabbitmq.example1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class JsonSearchBootApp {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(JsonSearchBootApp.class, args);
	}
}