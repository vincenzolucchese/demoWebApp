package com.vince.boot.demo.webapp.be.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.support.PagedListHolder;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;


public interface BaseEntityToDtoRepository {

	BaseDto saveDto(BaseDto entityDto);
	BaseDto saveDto(BaseDto entityDto, String user);
	BaseDto saveDto(BaseDto entityDto, String user, Date date);
	
	List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto);
	List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user);
	List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user, Date date);
	
	BaseDto findOneDto(Long id);
	List<BaseDto> findAllDto(BaseDto filter);
	
	PagedListHolder<BaseDto> findUsersPagedByCriteria(BaseDto searchBean, int i, Integer displayTagObjectsPerPage, String sort, boolean b) ;
}