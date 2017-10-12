/*
 * Copyright 2013-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vince.boot.demo.webapp.be.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.OrderJob;
import com.vince.boot.demo.webapp.be.entity.TypeDocument;
import com.vince.boot.demo.webapp.be.entity.UserApp;
import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.CommonDtoRepository;
import com.vince.boot.demo.webapp.be.service.OrderJobRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.ClientAppRepository;
import com.vince.boot.demo.webapp.be.service.TypeDocumentRepository;
import com.vince.boot.demo.webapp.be.service.UserAppRepository;
import com.vince.boot.demo.webapp.be.utility.PageableUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;

/**
 * Bean Service for common custom implementation about all web app
 * @author Vincenzo
 *
 */
@Component("commonAppRepositoryImpl")
public class CommonAppRepositoryImpl extends JdbcDaoSupport implements CommonDtoRepository {

	private static final Logger logger = LoggerFactory.getLogger(CommonAppRepositoryImpl.class);
	public static final String USER_SYSTEM = "SYSTEM";
	private static final String GET_SYSDATE_SQL = "SELECT SYSDATE()";
	
	@PersistenceContext 
	private EntityManager em;
	
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
	UserAppRepository userAppRepository;
	@Autowired
	OrderJobRepository orderJobRepository;

	/**
	 * Configure the entity manager to be used.	 * 
	 * @param em the {@link EntityManager} to set.
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Autowired
	public CommonAppRepositoryImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	/**
	 * get the sysdate from DB, very bad because depends from working db  
	 * 
	 * @return a date from DB
	 */
	public Date getSysdateFromDBJdbc() {
		logger.debug("JDBC");
		return getJdbcTemplate().queryForObject(GET_SYSDATE_SQL, Date.class);
	}
	

	@Override
	public void saveDocument(BlobStoreDto entityDto, String username) throws IOException {
//		BlobStore entity = new BlobStore();
//		int posix = entityDto.getFileDocuments().size()-1;
//		BlobStoreDto blobStoreFE = baseFE.getFileDocuments().get(posix);
//
//		MultipartFile multipartFile = blobStoreFE.getFile();
//
//		entity.setFilename(multipartFile.getOriginalFilename());
//		entity.setDescription(blobStoreFE.getDescription());
//		entity.setContentType(multipartFile.getContentType());
//		
//		TypeDocument typeDocument = new TypeDocument(new Long(1));
//		entity.setTypeDocument(typeDocument);
//		entity.setBlobData(multipartFile.getBytes());
//
//		entity = (BlobStore) saveCustom(entity, username);
//		
//		BeanUtils.copyProperties(entity, blobStoreFE);
//		
//		baseFE.getFileDocuments().set(posix, blobStoreFE);
		
	}

	@Override
	public UserAppDto saveUserAppDto(UserAppDto entityDto) {
		UserApp entity = UserAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(USER_SYSTEM);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			UserApp temp = userAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(USER_SYSTEM);
			entity.setTimeUpdate(dateDB);
		}		
		entity = userAppRepository.save(entity);
		return UserAppDto.createDtoFromEntity(entity);
	}

	@Override
	public UserAppDto saveUserAppDto(UserAppDto entityDto, String user) {
		UserApp entity = UserAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			UserApp temp = userAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		entity = userAppRepository.save(entity);
		return UserAppDto.createDtoFromEntity(entity);
	}

	@Override
	public UserAppDto saveUserAppDto(UserAppDto entityDto, String user, Date date) {
		UserApp entity = UserAppDto.createEntityFromDto(entityDto);
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(date);
			entity.setYearRefer(date);
		}else {
			UserApp temp = userAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(date);
		}		
		entity = userAppRepository.save(entity);
		return UserAppDto.createDtoFromEntity(entity);
	}

	@Override
	@Transactional
	public List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto) {
		if (entitiesDto == null) {
			return null;
		}
		List<UserAppDto> result = new ArrayList<UserAppDto>();
		for (UserAppDto each : entitiesDto) {
			result.add(saveUserAppDto(each));
		}
		return result;
	}

	@Override
	@Transactional
	public List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto, String user) {
		if (entitiesDto == null) {
			return null;
		}
		List<UserAppDto> result = new ArrayList<UserAppDto>();
		Date dateDB = getSysdateFromDBJdbc();
		for (UserAppDto each : entitiesDto) {
			result.add(saveUserAppDto(each, user, dateDB));
		}
		return result;
	}

	@Override
	@Transactional
	public List<UserAppDto> saveUserAppDto(Iterable<UserAppDto> entitiesDto, String user, Date date) {
		if (entitiesDto == null) {
			return null;
		}
		List<UserAppDto> result = new ArrayList<UserAppDto>();
		for (UserAppDto each : entitiesDto) {
			result.add(saveUserAppDto(each, user, date));
		}
		return result;
	}

	@Override
	@Transactional
	public UserAppDto findOneDto(UserAppDto filter) {
		UserApp entity = UserAppDto.createEntityFromDto(filter);
		Example<UserApp> example = Example.of(entity);
		entity = userAppRepository.findOne(example);
		return UserAppDto.createDtoFromEntity(entity);
	}

	@Override
	@Transactional
	public List<UserAppDto> findAllDto(UserAppDto filter) {
		UserApp entity = UserAppDto.createEntityFromDto(filter);
		Example<UserApp> example = Example.of(entity);
		List<UserApp> listEntity = userAppRepository.findAll(example);
		if(listEntity==null){
			return null;
		}
		List<UserAppDto> lista = new ArrayList<UserAppDto>();
		for (UserApp each : listEntity) {
			lista.add(UserAppDto.createDtoFromEntity(each));
		}
		return lista;
	}

	@Override
	@Transactional
	public PagedListHolder<UserAppDto> findDtoPagedByCriteria(UserAppDto searchBean, int i,
			Integer displayTagObjectsPerPage, String sort, boolean b) {
		Pageable pageable = PageableUtils.constructPageSpecification(i, displayTagObjectsPerPage.intValue(), sort, Boolean.valueOf(b));
		Page<UserApp> entityPage = null;

		UserApp entity = UserAppDto.createEntityFromDto(searchBean);
		Example<UserApp> example = Example.of(entity);
		entityPage = userAppRepository.findAll(example, pageable);
		
		if(entityPage == null) {
			return null;
		}
		ArrayList<UserAppDto> listaDto = new ArrayList<UserAppDto>();
		for (UserApp eachEntity : entityPage) {
			listaDto.add(UserAppDto.createDtoFromEntity(eachEntity));
		}
		PagedListHolder<UserAppDto> beanPage = new PagedListHolder<UserAppDto>(listaDto);
		return beanPage;
	}

	@Override
	public Long deleteDto(UserAppDto entityDto) {
		UserApp entity = UserAppDto.createEntityFromDto(entityDto);
		if(entity.getId()!=null){
			userAppRepository.delete(entity.getId());
		}else{
			userAppRepository.delete(entity);			
		}		
		return null;
	}

	@Override
	public ClientAppDto saveClientAppDto(ClientAppDto entityDto) {
		ClientApp entity = ClientAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(USER_SYSTEM);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			ClientApp temp = clientAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(USER_SYSTEM);
			entity.setTimeUpdate(dateDB);
		}		
		entity = clientAppRepository.save(entity);
		return ClientAppDto.createDtoFromEntity(entity);
	}

	@Override
	public ClientAppDto saveClientAppDto(ClientAppDto entityDto, String user) {
		ClientApp entity = ClientAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			ClientApp temp = clientAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		entity = clientAppRepository.save(entity);
		return ClientAppDto.createDtoFromEntity(entity);
	}

	@Override
	public ClientAppDto saveClientAppDto(ClientAppDto entityDto, String user, Date date) {
		ClientApp entity = ClientAppDto.createEntityFromDto(entityDto);
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(date);
			entity.setYearRefer(date);
		}else {
			ClientApp temp = clientAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(date);
		}		
		entity = clientAppRepository.save(entity);
		return ClientAppDto.createDtoFromEntity(entity);
	}

	@Override
	public List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto) {
		if (entitiesDto == null) {
			return null;
		}
		List<ClientAppDto> result = new ArrayList<ClientAppDto>();
		for (ClientAppDto each : entitiesDto) {
			result.add(saveClientAppDto(each));
		}
		return result;
	}

	@Override
	public List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto, String user) {
		if (entitiesDto == null) {
			return null;
		}
		List<ClientAppDto> result = new ArrayList<ClientAppDto>();
		for (ClientAppDto each : entitiesDto) {
			result.add(saveClientAppDto(each, user, getSysdateFromDBJdbc()));
		}
		return result;
	}

	@Override
	public List<ClientAppDto> saveClientAppDto(Iterable<ClientAppDto> entitiesDto, String user, Date date) {
		if (entitiesDto == null) {
			return null;
		}
		List<ClientAppDto> result = new ArrayList<ClientAppDto>();
		for (ClientAppDto each : entitiesDto) {
			result.add(saveClientAppDto(each, user, date));
		}
		return result;
	}

	@Override
	public ClientAppDto findOneDto(ClientAppDto filter) {
		ClientApp entity = ClientAppDto.createEntityFromDto(filter);
		Example<ClientApp> example = Example.of(entity);
		return ClientAppDto.createDtoFromEntity(clientAppRepository.findOne(example));
	}

	@Override
	public List<ClientAppDto> findAllDto(ClientAppDto filter) {
		ClientApp entity = ClientAppDto.createEntityFromDto(filter);
		Example<ClientApp> example = Example.of(entity);
		List<ClientApp> listEntity = clientAppRepository.findAll(example);
		if(listEntity==null){
			return null;
		}
		List<ClientAppDto> lista = new ArrayList<ClientAppDto>();
		for (ClientApp each : listEntity) {
			lista.add(ClientAppDto.createDtoFromEntity(each));
		}
		return lista;
	}

	@Override
	public PagedListHolder<ClientAppDto> findDtoPagedByCriteria(ClientAppDto searchBean, int i,
			Integer displayTagObjectsPerPage, String sort, boolean b) {
		Pageable pageable = PageableUtils.constructPageSpecification(i, displayTagObjectsPerPage.intValue(), sort, Boolean.valueOf(b));
		Page<ClientApp> entityPage = null;

		ClientApp entity = ClientAppDto.createEntityFromDto(searchBean);
		Example<ClientApp> example = Example.of(entity);
		entityPage = clientAppRepository.findAll(example, pageable);
		
		if(entityPage == null) {
			return null;
		}
		ArrayList<ClientAppDto> listaDto = new ArrayList<ClientAppDto>();
		for (ClientApp eachEntity : entityPage) {
			listaDto.add(ClientAppDto.createDtoFromEntity(eachEntity));
		}
		PagedListHolder<ClientAppDto> beanPage = new PagedListHolder<ClientAppDto>(listaDto);
		return beanPage;
	}

	@Override
	public Long deleteDto(ClientAppDto entityDto) {
		ClientApp entity = ClientAppDto.createEntityFromDto(entityDto);
		if(entity.getId()!=null){
			clientAppRepository.delete(entity.getId());
		}else{
			clientAppRepository.delete(entity);			
		}		
		return null;
	}

	@Override
	public OrderJobDto saveOrderJobDto(OrderJobDto entityDto) {
		OrderJob entity = OrderJobDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(USER_SYSTEM);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			OrderJob temp = orderJobRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(USER_SYSTEM);
			entity.setTimeUpdate(dateDB);
		}		
		entity = orderJobRepository.save(entity);
		return OrderJobDto.createDtoFromEntity(entity);
	}

	@Override
	public OrderJobDto saveOrderJobDto(OrderJobDto entityDto, String user) {
		OrderJob entity = OrderJobDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			OrderJob temp = orderJobRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		entity = orderJobRepository.save(entity);
		return OrderJobDto.createDtoFromEntity(entity);
	}

	@Override
	public OrderJobDto saveOrderJobDto(OrderJobDto entityDto, String user, Date date) {
		OrderJob entity = OrderJobDto.createEntityFromDto(entityDto);
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(date);
			entity.setYearRefer(date);
		}else {
			OrderJob temp = orderJobRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(date);
		}		
		entity = orderJobRepository.save(entity);
		return OrderJobDto.createDtoFromEntity(entity);
	}

	@Override
	public List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderJobDto findOneDto(OrderJobDto filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderJobDto> findAllDto(OrderJobDto filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagedListHolder<OrderJobDto> findDtoPagedByCriteria(OrderJobDto searchBean, int i,
			Integer displayTagObjectsPerPage, String sort, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long deleteDto(OrderJobDto entityDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db in input.
	 * Each Entity extends BaseEntity and Casting on entity in input
	 * Allow to use only BaseEntityRepository on BaseEntity
	 * @param entity
	 * @param user
	 * @return
	 */
	public BaseEntity saveCustom(BaseEntity entity, String user, Date dateDB) {
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db.
	 * Each Entity extends BaseEntity and Casting on entity in input
	 * Allow to use only BaseEntityRepository on BaseEntity
	 * @param entity
	 * @param user
	 * @return
	 */
	public BaseEntity saveCustom(BaseEntity entity, String user) {
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			entity.setUserInsert(user);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
			
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db.
	 * Each Entity extends BaseEntity and Casting on entity in input
	 * Allow to use only BaseEntityRepository on BaseEntity
	 * @param entity
	 * @param user
	 * @return
	 */
	public BaseEntity saveCustom(BaseEntity entity) {
		Date dateDB = getSysdateFromDBJdbc();
		if(entity.isNew()){
			entity.setUserInsert(USER_SYSTEM);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			entity.setUserInsert(USER_SYSTEM);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
			
			entity.setUserUpdate(USER_SYSTEM);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a collection of entity.
	 * Each Entity extends BaseEntity and Casting on entity in input
	 * Allow to use only BaseEntityRepository on BaseEntity
	 * @param entity
	 * @param user
	 * @return
	 */
	@Transactional
	public List<BaseEntity> saveCustom(Iterable<BaseEntity> entities, String user) {
		List<BaseEntity> result = new ArrayList<BaseEntity>();
		if (entities == null) {
			return result;
		}
		Date dateDB = getSysdateFromDBJdbc();
		for (BaseEntity entity : entities) {
			result.add(saveCustom(entity, user, dateDB));
		}
		return result;
	}

	/**********************************************************************************************************
	 * IMPLEMETATION OF BaseEntityToDtoRepository 
	 * These method can be used from FE-SIDE that know only about Dtos Bean, mirror of Entities.
	 * All methods use as primitive repository the BaseEntityRepository with the AutoCasting allow
	 * to implement the simple CRUD about all Entities.
	 * Is the abstract method createEntityFromDto of BaseDto that allow the above Autocasting.
	 * ...working about pageable if is possibile, if not is necessary utilize other JPA pattern. 	
	 **********************************************************************************************************/
	@Override
	public BaseDto saveDto(BaseDto dto) {
		BaseEntity entity = dto.createEntityFromDto(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity);		
		return dto.createDtoFromEntity(entity);
	}

	@Override
	public BaseDto saveDto(BaseDto dto, String user) {
		BaseEntity entity = dto.createEntityFromDto(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity, user);		
		return dto.createDtoFromEntity(entity);
	}

	@Override
	public BaseDto saveDto(BaseDto dto, String user, Date date) {
		BaseEntity entity = dto.createEntityFromDto(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity, user, date);		
		return dto.createDtoFromEntity(entity);
	}

	@Override
	@Transactional
	public List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto) {
		if(entitiesDto == null) return null;
		List<BaseDto> lista = new ArrayList<BaseDto>();
		for (BaseDto each : entitiesDto) {
			lista.add(this.saveDto(each));
		}
		return lista;
	}

	@Override
	@Transactional
	public List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user) {
		if(entitiesDto == null) return null;
		List<BaseDto> lista = new ArrayList<BaseDto>();
		for (BaseDto each : entitiesDto) {
			lista.add(this.saveDto(each, user));
		}
		return lista;
	}

	@Override
	@Transactional
	public List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user, Date date) {
		if(entitiesDto == null) return null;
		List<BaseDto> lista = new ArrayList<BaseDto>();
		for (BaseDto each : entitiesDto) {
			lista.add(this.saveDto(each, user, date));
		}
		return lista;
	}

	@Override
	@Transactional
	public BaseDto findOneDto(BaseDto filter) {	
		BaseEntity entity = filter.createEntityFromDto(filter);
		Example<BaseEntity> example = Example.of(entity);
		return filter.createDtoFromEntity(baseEntityRepository.findOne(example));
	}

	@Override
	@Transactional
	public List<BaseDto> findAllDto(BaseDto filter) {
		List<BaseDto> listaDto = null;
		BaseEntity entity = filter.createEntityFromDto(filter);
		Example<BaseEntity> example = Example.of(entity);
		List<BaseEntity> listaEntity = baseEntityRepository.findAll(example);
		if(listaEntity !=null) {
			listaDto = new ArrayList<BaseDto>();
			for (BaseEntity eachEntity : listaEntity) {
				listaDto.add(filter.createDtoFromEntity(eachEntity));
			}
		}else {
			listaDto = null;			
		}
		return listaDto;
	}

	@Override
	@Transactional
	public PagedListHolder<BaseDto> findDtoPagedByCriteria(BaseDto searchBean, int i, Integer displayTagObjectsPerPage, String sort, boolean b) {
		Pageable pageable = PageableUtils.constructPageSpecification(i, displayTagObjectsPerPage.intValue(), sort, Boolean.valueOf(b));
		Page<BaseEntity> entityPage = null;

		BaseEntity entity = searchBean.createEntityFromDto(searchBean);
		Example<BaseEntity> example = Example.of(entity);
		entityPage = baseEntityRepository.findAll(example, pageable);
		
		if(entityPage == null) {
			return null;
		}
		ArrayList<BaseDto> listaDto = new ArrayList<BaseDto>();
		for (BaseEntity eachEntity : entityPage) {
			listaDto.add(searchBean.createDtoFromEntity(eachEntity));
		}
		PagedListHolder<BaseDto> beanPage = new PagedListHolder<>(listaDto);
		return beanPage;
	}
	
	@Override
	public Long deleteDto(BaseDto entityDto) {
		BaseEntity entity = entityDto.createEntityFromDto(entityDto);
		baseEntityRepository.delete(entity);
		return 1l;
	}
	
	@Override
	public void saveDocument(BaseDto baseFE, String username) throws IOException {

		BlobStore entity = new BlobStore();
		int posix = baseFE.getFileDocuments().size()-1;
		BlobStoreDto blobStoreFE = baseFE.getFileDocuments().get(posix);

		MultipartFile multipartFile = blobStoreFE.getFile();

		entity.setFilename(multipartFile.getOriginalFilename());
		entity.setDescription(blobStoreFE.getDescription());
		entity.setContentType(multipartFile.getContentType());
		
		TypeDocument typeDocument = new TypeDocument(new Long(1));
		entity.setTypeDocument(typeDocument);
		entity.setBlobData(multipartFile.getBytes());

		entity = (BlobStore) saveCustom(entity, username);
		
		BeanUtils.copyProperties(entity, blobStoreFE);
		
		baseFE.getFileDocuments().set(posix, blobStoreFE);
	}

	@Override
	public BlobStoreDto findOneBlobStoreDto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAppDto findOneUserAppDto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientAppDto findOneClientAppDto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderJobDto findOneOrderJobDto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
