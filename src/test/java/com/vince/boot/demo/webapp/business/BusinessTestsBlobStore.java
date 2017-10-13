package com.vince.boot.demo.webapp.business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.QBlobStore;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsBlobStore extends BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsBlobStore.class);
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}
	
	
	@Test	
	public void getBlobByClientApp() throws IOException {
		logger.debug("let's start...");
		

		ClientApp client = new ClientApp(11l);
		
		List<BlobStore> lista = blobStoreRepository.findByFlagActiveAndRelClientBlobs_ClientApp('1', client);
		
		logger.debug(""+lista.size());
	}

	
	@Test	
	public void saveBlob() throws IOException {
		logger.debug("...STARTING...");
		
		String PATH = "src/test/resources/files/";
		InputStream fis = new FileInputStream(PATH + "immagine1.jpg");
		
		BlobStore entity = new BlobStore();
		entity.setBlobData(FileCopyUtils.copyToByteArray(fis));
		
		entity.setContentType("application/jpeg");
		entity.setDescription("ok");
		entity.setFilename("Filename");
		entity.setFlagActive('1');
		entity.setTypeDocument(typeDocumentRepository.findOne(1l));
//		entity = (BlobStore) commonAppRepositoryImpl.saveCustom(entity, "insert");		
		
		logger.debug(""+entity);
	}
	
	@Test	
	@Transactional
	@Rollback(false)
	public void findSaveClientWithBlob() throws IOException {
		logger.debug("inizio");
		
		QBlobStore qdsl = QBlobStore.dBlobStore;
		
		BooleanExpression bex = qdsl.filename.eq("Filename");
		bex.and(qdsl.id.eq(1l));
		
		BlobStore blob = blobStoreRepository.findOne(bex);
		
		ClientApp clientapp = new ClientApp();
		clientapp.setName("setName");
		clientapp.setPiva("setPiva");
		clientapp.setAddress("setAddress");
		clientapp.setZipcode("12345");
		clientapp.setNotes("setNotes");
//		clientapp = (ClientApp) commonAppRepositoryImpl.saveCustom(clientapp, "insert");

		RelClientBlob rel1 = new RelClientBlob();
		rel1.setBlobStore(blob);
		rel1.setClientApp(clientapp);
//		rel1 = (RelClientBlob) commonAppRepositoryImpl.saveCustom(rel1, "insert");
		
		blob = blobStoreRepository.findOne(1l);		
		
		logger.debug("--- "+blob.getRelClientBlobs());
	}
	

}
