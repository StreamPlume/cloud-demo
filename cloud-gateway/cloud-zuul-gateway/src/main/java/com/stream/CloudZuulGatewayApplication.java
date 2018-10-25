package com.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableZuulProxy
//@EnableOAuth2Client
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CloudZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudZuulGatewayApplication.class, args);
	}
}
