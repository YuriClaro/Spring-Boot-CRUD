package com.humanit.yuriclaro_exercicio_spring_boot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.humanit.yuriclaro_exercicio_spring_boot_1")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
