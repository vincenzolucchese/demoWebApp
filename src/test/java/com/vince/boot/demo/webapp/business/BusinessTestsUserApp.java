package com.vince.boot.demo.webapp.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsUserApp extends BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsUserApp.class);
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}
	
	/*******************************************************************************
	 * FE
	 *******************************************************************************/
	@Test	
	public void saveSomeUserDto() {
		logger.debug("-- Start --");
		UserAppDto temp = commonAppRepositoryImpl.findOneUserAppDto(new Long(1));
		
		List<UserAppDto> lista = new ArrayList<UserAppDto>();
		for(int i = 0; i<20 ; ++i) {
			int a = i +1;
			UserAppDto each = new UserAppDto();
			each.setId(null);
			each.setUsername("ciaone"+i);
			lista.add(each);
		}
		
		commonAppRepositoryImpl.saveUserAppDto(lista);

	}
	
	

}
