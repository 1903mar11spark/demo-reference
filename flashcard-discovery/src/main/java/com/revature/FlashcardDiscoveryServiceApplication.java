package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //allows this application to act as a service registry
public class FlashcardDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardDiscoveryServiceApplication.class, args);
	}

}
