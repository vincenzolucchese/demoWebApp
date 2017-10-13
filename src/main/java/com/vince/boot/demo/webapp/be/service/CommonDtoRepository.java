package com.vince.boot.demo.webapp.be.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.support.PagedListHolder;

import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;


public interface CommonDtoRepository {
	
	/*
	 * RoleUserDto
	 */
	RoleUserDto findOneRoleUserDto(Long id);
	List<RoleUserDto> findAllDto(RoleUserDto filter);
	
	/*
	 * BlobStoreDto
	 */
	BlobStoreDto findOneBlobStoreDto(Long id);
	void saveDocument(BlobStoreDto entityDto, String username) throws IOException;
	
	/*
	 * UserAppDto
	 */
	UserAppDto saveUserAppDto(UserAppDto entityDto);
	UserAppDto saveUserAppDto(UserAppDto entityDto, String user);
	UserAppDto saveUserAppDto(UserAppDto entityDto, String user, Date date);
	List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto);
	List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto, String user);
	List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto, String user, Date date);
	
	UserAppDto findOneUserAppDto(Long id);
	UserAppDto findOneDto(UserAppDto filter);
	List<UserAppDto> findAllDto(UserAppDto filter);
	
	PagedListHolder<UserAppDto> findDtoPagedByCriteria(UserAppDto searchBean, int i, Integer displayTagObjectsPerPage, String sort, boolean b) ;
	Long deleteDto(UserAppDto entityDto);
	
	/*
	 * ClientAppDto
	 */
	ClientAppDto saveClientAppDto(ClientAppDto entityDto);
	ClientAppDto saveClientAppDto(ClientAppDto entityDto, String user);
	ClientAppDto saveClientAppDto(ClientAppDto entityDto, String user, Date date);
	List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto);
	List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto, String user);
	List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto, String user, Date date);
	
	ClientAppDto findOneClientAppDto(Long id);
	ClientAppDto findOneDto(ClientAppDto filter);
	List<ClientAppDto> findAllDto(ClientAppDto filter);
	
	PagedListHolder<ClientAppDto> findDtoPagedByCriteria(ClientAppDto searchBean, int i, Integer displayTagObjectsPerPage, String sort, boolean b) ;
	Long deleteDto(ClientAppDto entityDto);
	
	/*
	 * OrderJobDto
	 */
	OrderJobDto saveOrderJobDto(OrderJobDto entityDto);
	OrderJobDto saveOrderJobDto(OrderJobDto entityDto, String user);
	OrderJobDto saveOrderJobDto(OrderJobDto entityDto, String user, Date date);
	List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto);
	List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user);
	List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user, Date date);
	
	OrderJobDto findOneOrderJobDto(Long id);
	OrderJobDto findOneDto(OrderJobDto filter);
	List<OrderJobDto> findAllDto(OrderJobDto filter);
	
	PagedListHolder<OrderJobDto> findDtoPagedByCriteria(OrderJobDto searchBean, int i, Integer displayTagObjectsPerPage, String sort, boolean b) ;
	Long deleteDto(OrderJobDto entityDto);
	
}
