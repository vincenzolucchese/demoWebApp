package com.vince.boot.demo.webapp.business;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vince.boot.demo.webapp.be.entity.DBlobStore;
import com.vince.boot.demo.webapp.be.entity.DClientApp;
import com.vince.boot.demo.webapp.be.entity.DRelClientBlob;
import com.vince.boot.demo.webapp.be.entity.DTypeDocument;
import com.vince.boot.demo.webapp.be.entity.QDBlobStore;
import com.vince.boot.demo.webapp.be.entity.QDClientApp;
import com.vince.boot.demo.webapp.be.service.DBlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.DClientAppRepository;
import com.vince.boot.demo.webapp.be.service.DTypeDocumentRepository;
import com.vince.boot.demo.webapp.be.service.impl.CommonAppRepositoryImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsBlobStore {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsBlobStore.class);
	
	@Autowired
	CommonAppRepositoryImpl commonService;
	
	@Autowired
	DBlobStoreRepository entityService;
	@Autowired
	DTypeDocumentRepository typeDocEntityService;
	
	@Test
	public void contextLoads() {
		logger.debug("--");
	}
	

	
	@Test	
	public void saveBlob() throws IOException {
		logger.debug("--");
		
		String PATH = "src/test/resources/files/";
		InputStream fis = new FileInputStream(PATH + "immagine1.jpg");
		
		DBlobStore entity = new DBlobStore();
		entity.setBlobData(FileCopyUtils.copyToByteArray(fis));
		
		entity.setContentType("application/jpeg");
		entity.setDescription("ok");
		entity.setFilename("Filename");
		entity.setFlagActive('1');
		entity.setDTypeDocument(typeDocEntityService.findOne(1l));
		
		entity = (DBlobStore) commonService.saveCustom(entity, "insert");
		
		
		logger.debug(""+entity);
	}
	
	@Test	
	@Transactional
	@Rollback(false)
	public void findSaveClientWithBlob() throws IOException {
		logger.debug("inizio");
		
		QDBlobStore qdsl = QDBlobStore.dBlobStore;
		
		BooleanExpression bex = qdsl.filename.eq("Filename");
		bex.and(qdsl.id.eq(1l));
		
		DBlobStore blob = entityService.findOne(bex);
		
		DClientApp clientapp = new DClientApp();
		clientapp.setName("setName");
		clientapp.setPiva("setPiva");
		clientapp.setAddress("setAddress");
		clientapp.setZipcode("12345");
		clientapp.setNotes("setNotes");
		clientapp = (DClientApp) commonService.saveCustom(clientapp, "insert");

		DRelClientBlob rel1 = new DRelClientBlob();
		rel1.setDBlobStore(blob);
		rel1.setDClientApp(clientapp);
		rel1 = (DRelClientBlob) commonService.saveCustom(rel1, "insert");
		
		blob = entityService.findOne(1l);
		
		
		logger.debug("--- "+blob.getDRelClientBlobs());
	}
	

}
