package com.vince.boot.demo.webapp.business;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vince.boot.demo.webapp.be.entity.DClientApp;
import com.vince.boot.demo.webapp.be.entity.QDClientApp;
import com.vince.boot.demo.webapp.be.service.DClientAppRepository;
import com.vince.boot.demo.webapp.be.service.impl.CommonAppRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsClientApp {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsClientApp.class);
	
	@Autowired
	CommonAppRepositoryImpl commonService;
	
	@Autowired
	DClientAppRepository entityService;
	
	@Test
	public void contextLoads() {
		logger.debug("--");
	}
	

	
	@Test	
	public void saveClientApp() {
		logger.debug("--");
		DClientApp entity = new DClientApp();
		entity.setName("setName");
		entity.setPiva("setPiva");
		entity.setAddress("setAddress");
		entity.setZipcode("12345");
		entity.setNotes("setNotes");
		commonService.saveCustom(entity, "insert");

		logger.debug(""+entity);
	}
	
	@Test	
	public void findSaveClientApp() {
		logger.debug("--");
		DClientApp entity = entityService.findOne(4l);
		logger.debug(entity.toString());
		commonService.saveCustom(entity, "update");

		logger.debug(""+entity);
	}
	
	@Test	
	public void findPredicateClientApp() {
		logger.debug("-- Start --");
		
		QDClientApp qdsl = QDClientApp.dClientApp;

		BooleanExpression queryExpression = qdsl.userInsert.eq("insert");
		List<DClientApp> lista = (List<DClientApp>) entityService.findAll(queryExpression);
		for (DClientApp each : lista) {
			commonService.saveCustom(each, "update1");
		}


		logger.debug(""+lista);
	}

}
