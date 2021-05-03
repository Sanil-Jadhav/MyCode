package com.sanil.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.sanil.*")
@EnableMongoRepositories(basePackages = "com.sanil.repository")
public class DataAcquisistionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAcquisistionApplication.class, args);
	}

}
