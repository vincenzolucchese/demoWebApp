package com.vince.boot.demo.webapp.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;
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
		for(int i = 30; i<2000 ; ++i) {
			int a = i +1;
			UserAppDto each = new UserAppDto();
			BeanUtils.copyProperties(temp, each);
			each.setRoleUser(new RoleUserDto(1l));
			each.setId(null);
			each.setUsername("ciaone"+i);
			each.setRelUserBlobs(null);
			lista.add(each);
		}
		
		commonAppRepositoryImpl.saveUserAppDto(lista);

	}
	
	

}
