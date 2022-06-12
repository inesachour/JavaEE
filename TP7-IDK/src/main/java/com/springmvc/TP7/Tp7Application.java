package com.springmvc.TP7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Tp7Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp7Application.class, args);
	}

}
