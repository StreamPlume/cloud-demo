package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class CloudTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudTurbineApplication.class, args);
	}
}
