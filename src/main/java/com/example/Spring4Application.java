package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class Spring4Application {

	public static void main(String[] args) {
		
		//System.setProperty("spring.devtools.restart.enabled", "false");
		//System.out.println("&&&&&&7spring.devtools.restart.enabled");
		SpringApplication.run(Spring4Application.class, args);
		
		
	}
}
