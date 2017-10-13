package com.vince.boot.demo.webapp.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsRoleUser extends BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsRoleUser.class);
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}
	
	/*******************************************************************************
	 * FE
	 *******************************************************************************/
	@Test	
	public void findAllRoleUserDto() {
		logger.debug("-- Start --");
//		Collection<BaseDto> rolesByDB = baseEntityToDtoRepository.findAllDto(new RoleUserDto());

//		logger.debug("-- END --"+rolesByDB.size());
	}
	
	
	@Test	
	public void findPagebleOrderJobDto() {
		logger.debug("-- Start --");
		
//		PagedListHolder<BaseDto> listBeanTable = 
//				commonAppRepositoryImpl.findDtoPagedByCriteria(new OrderJobDto(), 0, 10, "timeInsert", false);
//		
//		logger.debug("-- END --"+listBeanTable.getNrOfElements());
	}

}
