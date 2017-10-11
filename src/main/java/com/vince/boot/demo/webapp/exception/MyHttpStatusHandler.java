package com.vince.boot.demo.webapp.exception;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

// handle 403 page
@Component
public class MyHttpStatusHandler extends ErrorMvcAutoConfiguration {

    public MyHttpStatusHandler(ServerProperties serverProperties,
			ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
		super(serverProperties, errorViewResolversProvider);
		// TODO Auto-generated constructor stub
	}

	private static Logger logger = LoggerFactory.getLogger(MyHttpStatusHandler.class);


}
