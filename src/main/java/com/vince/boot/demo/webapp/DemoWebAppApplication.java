package com.vince.boot.demo.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoWebAppApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(DemoWebAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebAppApplication.class, args);
		
		logger.debug("...App is Started....");
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//only for test
        return application.sources(DemoWebAppApplication.class).headless(false);
//        return application.sources(SpringBootWebApplication.class);
    }
}
