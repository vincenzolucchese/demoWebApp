package com.vince.boot.demo.webapp.business;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.BaseEntityToDtoRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.ClientAppRepository;
import com.vince.boot.demo.webapp.be.service.TypeDocumentRepository;
import com.vince.boot.demo.webapp.be.service.impl.CommonAppRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTests.class);
	
	public static final String PATH_FILES = "src/test/resources/files/";
	
	@Autowired
	BaseEntityRepository baseEntityRepository;	
	@Autowired
	CommonAppRepositoryImpl commonAppRepositoryImpl;
	@Autowired
	BlobStoreRepository blobStoreRepository;
	@Autowired
	TypeDocumentRepository typeDocumentRepository;
	@Autowired
	ClientAppRepository clientAppRepository;
	@Autowired
	BaseEntityToDtoRepository baseEntityToDtoRepository;
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}
	
	@Test	
	public void getDataJdbc() {
		logger.debug("...STARTING...");
		Date data = commonAppRepositoryImpl.getSysdateFromDBJdbc();
		logger.debug(""+data);
	}
	
	@Test	
	public void saveGeneric() {
//		logger.debug("...STARTING...");
//		TableDemo entity = new TableDemo();
//		entity.setUserInsert("aasssddff");
//		entity.setTimeInsert(service.getSysdateFromDBJdbc());
//		entity = serv.save(entity);
//
//		logger.debug(""+entity);
	}
	

}
