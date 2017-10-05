package com.vince.boot.demo.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebAppApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoWebAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebAppApplication.class, args);
		
		logger.debug("...App is Started....");
	}
}
