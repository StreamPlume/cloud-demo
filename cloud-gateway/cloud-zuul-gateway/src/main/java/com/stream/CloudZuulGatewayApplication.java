package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
//@EnableOAuth2Sso
public class CloudZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulGatewayApplication.class, args);
	}
}
