package com.vince.boot.demo.webapp.business;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.QClientApp;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;
import com.vince.boot.demo.webapp.be.entity.TypeDocument;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsClientApp extends BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsClientApp.class);
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}

	
	@Test	
	public void saveSimpleClientApp() {
		logger.debug("...STARTING...");
		ClientApp entity = new ClientApp();
		entity.setName("setName");
		entity.setPiva("setPiva");
		entity.setAddress("setAddress");
		entity.setZipcode("12345");
		entity.setNotes("setNotes");
		commonAppRepositoryImpl.saveCustom(entity, "insert");

		logger.debug(""+entity);
	}
	
	@Test	
	@Transactional
	@Rollback(false)
	public void saveFullClientApp() throws IOException {
		logger.debug("...STARTING...");
				
		String user = "inserter";
		Date dateDB = commonAppRepositoryImpl.getSysdateFromDBJdbc();
		
		TypeDocument typeDoc = typeDocumentRepository.findOne(1l);
		
		ClientApp entity = new ClientApp();
		entity.setName("setName");
		entity.setPiva("setPiva");
		entity.setAddress("setAddress");
		entity.setZipcode("12345");
		entity.setNotes("setNotes");
		
		InputStream fis1 = new FileInputStream(PATH_FILES + "immagine1.jpg");
		InputStream fis2 = new FileInputStream(PATH_FILES + "immagine2.jpg");
		
		BlobStore blb1 = new BlobStore();
		blb1.setBlobData(FileCopyUtils.copyToByteArray(fis1));		
		blb1.setContentType("application/jpeg");
		blb1.setDescription("ok");
		blb1.setFilename("Filename");
		blb1.setFlagActive('1');
		blb1.setTypeDocument(typeDoc);
		blb1 = (BlobStore) commonAppRepositoryImpl.saveCustom(blb1, user, dateDB);
		
		BlobStore blb2 = new BlobStore();
		blb2.setBlobData(FileCopyUtils.copyToByteArray(fis2));		
		blb2.setContentType("application/jpeg");
		blb2.setDescription("ok");
		blb2.setFilename("Filename");
		blb2.setFlagActive('1');
		blb2.setTypeDocument(typeDoc);
		blb2 = (BlobStore) commonAppRepositoryImpl.saveCustom(blb2, user, dateDB);
		
		HashSet<RelClientBlob> hash = new HashSet<RelClientBlob>();		
		RelClientBlob rel1 = new RelClientBlob(entity, blb1);
		RelClientBlob rel2 = new RelClientBlob(entity, blb2);
		hash.add(rel1);
		hash.add(rel2);		
		entity.setRelClientBlobs(hash);		
		commonAppRepositoryImpl.saveCustom(entity, user, dateDB);

		logger.debug(""+entity);
	}
	
	@Test	
	public void findSaveClientApp() {
		logger.debug("...STARTING...");
		ClientApp entity = clientAppRepository.findOne(4l);
		logger.debug(entity.toString());
		commonAppRepositoryImpl.saveCustom(entity, "update");

		logger.debug(""+entity);
	}
	
	@Test	
	public void findPredicateClientApp() {
		logger.debug("-- Start --");
		
		QClientApp qdsl = QClientApp.dClientApp;

		BooleanExpression queryExpression = qdsl.userInsert.eq("insert");
		List<ClientApp> lista = (List<ClientApp>) clientAppRepository.findAll(queryExpression);
		for (ClientApp each : lista) {
			commonAppRepositoryImpl.saveCustom(each, "update1");
		}
		logger.debug(""+lista);
	}
	
	/*******************************************************************************
	 * FE
	 *******************************************************************************/
	@Test	
	public void saveClientAppDto() {
		logger.debug("-- Start --");
		
		ClientAppDto dto = new ClientAppDto();
		dto.setName("setName");
		dto.setPiva("setPiva");
		dto.setAddress("setAddress");
		dto.setZipcode("12345");
		dto.setNotes("setNotes");
		
		dto = (ClientAppDto) commonAppRepositoryImpl.saveDto(dto);
		
		logger.debug("-- END --");
	}
	
	@Test	
	public void findPagebleClientAppDto() {
		logger.debug("-- Start --");
		
		ClientAppDto dto = new ClientAppDto();
		dto.setName("setName");
		dto.setPiva("setPiva");
//
//		PagedListHolder<BaseDto> listBeanTable = 
//				commonAppRepositoryImpl.findDtoPagedByCriteria(new ClientAppDto(), 0, 10, "timeInsert", false);
//		
//		logger.debug("-- END --"+listBeanTable.getNrOfElements());
	}
	

}
