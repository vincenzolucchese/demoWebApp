package com.vince.boot.demo.webapp.business;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vince.boot.demo.webapp.entity.DClientApp;
import com.vince.boot.demo.webapp.service.CommonAppRepository;
import com.vince.boot.demo.webapp.service.CommonAppRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTests.class);
	
	@Autowired
	CommonAppRepository serv;
	
	@Autowired
	CommonAppRepositoryImpl service;
	
	@Test
	public void contextLoads() {
		logger.debug("--");
	}
	
	@Test	
	public void getDataJdbc() {
		logger.debug("--");
		Date data = service.getSysdateFromDBJdbc();
		logger.debug(""+data);
	}
	
	@Test	
	public void saveGeneric() {
//		logger.debug("--");
//		TableDemo entity = new TableDemo();
//		entity.setUserInsert("aasssddff");
//		entity.setTimeInsert(service.getSysdateFromDBJdbc());
//		entity = serv.save(entity);
//
//		logger.debug(""+entity);
	}
	
	@Test	
	public void saveClientApp() {
		logger.debug("--");
		Date data = service.getSysdateFromDBJdbc();
		DClientApp entity = new DClientApp();
		entity.setId(12l);
		entity.setName("name");
		entity.setPiva("name");
		entity.setAddress("fsdfs");
		entity.setZipcode("123");
		entity.setNotes("sdcsdfsdf");
		entity.setYearRefer(data);
		entity.setUserInsert("aasssddff");
		entity.setTimeInsert(data);
		entity = serv.save(entity);

		logger.debug(""+entity);
	}

}
