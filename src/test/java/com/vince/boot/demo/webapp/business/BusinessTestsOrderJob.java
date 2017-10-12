package com.vince.boot.demo.webapp.business;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessTestsOrderJob extends BusinessTests {

	private static final Logger logger = LoggerFactory.getLogger(BusinessTestsOrderJob.class);
	
	@Test
	public void contextLoads() {
		logger.debug("...STARTING...");
	}
	
	/*******************************************************************************
	 * FE
	 *******************************************************************************/
	@Test	
	public void saveOrderJobDto() {
		logger.debug("-- Start --");
//		ClientAppDto dto = new ClientAppDto();
//		dto.setPiva("setPiva");
//		List<BaseDto> lista = baseEntityToDtoRepository.findAllDto(dto);
//		
//		ClientAppDto dto1 = new ClientAppDto(15l);
//		dto1 = (ClientAppDto) baseEntityToDtoRepository.findOneDto(dto1);
//		
//		OrderJobDto orderDto = new OrderJobDto();
//		orderDto.setClientApp(dto1);
//		orderDto.setNotes("adasdasdasd");
//		orderDto = (OrderJobDto) baseEntityToDtoRepository.saveDto(orderDto, "vince");		
//		
//		OrderJobDto orderFilter = new OrderJobDto();
//		orderFilter.setUserInsert("vince");
//		List<BaseDto> listaOrder = baseEntityToDtoRepository.findAllDto(orderFilter);
//		
//		logger.debug("-- END --"+listaOrder.size());
//		logger.debug("-- END --"+lista.size());
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
