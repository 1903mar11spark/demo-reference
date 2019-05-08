package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapServiceDemoApplication.class, args);
	}
}
