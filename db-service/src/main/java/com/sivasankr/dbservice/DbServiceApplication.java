package com.sivasankr.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DbServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbServiceApplication.class, args);
		System.out.println("DB Service Started");
	}

}
