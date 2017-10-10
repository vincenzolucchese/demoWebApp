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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.BaseEntityToDtoRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.ClientAppRepository;
import com.vince.boot.demo.webapp.be.service.TypeDocumentRepository;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;

/**
 * Bean Service for common custom implementation about all web app
 * @author Vincenzo
 *
 */
@Component("commonAppRepositoryImpl")
public class CommonAppRepositoryImpl extends JdbcDaoSupport implements BaseEntityToDtoRepository {

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
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db in input.
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
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db.
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
			entity.setUserUpdate(user);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a entity with the strategy about user inserter and updater. get sysdate from db.
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
			entity.setUserUpdate(USER_SYSTEM);
			entity.setTimeUpdate(dateDB);
		}		
		return baseEntityRepository.save(entity);
	}
	
	/**
	 * Save a collection of entity.
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

	/******************************************************************
	 *************** IMPLEMETATION OF BaseEntityToDtoRepository *******
	 ******************************************************************/
	@Override
	public BaseDto saveDto(BaseDto dto) {
		BaseEntity entity = BaseDto.createEntityFromDtoAbstract(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity);		
		return BaseDto.createDtoFromEntityAbstract(entity);
	}

	@Override
	public BaseDto saveDto(BaseDto dto, String user) {
		BaseEntity entity = BaseDto.createEntityFromDtoAbstract(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity, user);		
		return BaseDto.createDtoFromEntityAbstract(entity);
	}

	@Override
	public BaseDto saveDto(BaseDto dto, String user, Date date) {
		BaseEntity entity = BaseDto.createEntityFromDtoAbstract(dto);
		entity = commonAppRepositoryImpl.saveCustom(entity, user, date);		
		return BaseDto.createDtoFromEntityAbstract(entity);
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
	public List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user) {
		if(entitiesDto == null) return null;
		List<BaseDto> lista = new ArrayList<BaseDto>();
		for (BaseDto each : entitiesDto) {
			lista.add(this.saveDto(each, user));
		}
		return lista;
	}

	@Override
	public List<BaseDto> saveDto(Iterable<BaseDto> entitiesDto, String user, Date date) {
		if(entitiesDto == null) return null;
		List<BaseDto> lista = new ArrayList<BaseDto>();
		for (BaseDto each : entitiesDto) {
			lista.add(this.saveDto(each, user, date));
		}
		return lista;
	}

	@Override
	public BaseDto findOneDto(Long id) {		
		return BaseDto.createDtoFromEntityAbstract(baseEntityRepository.findOne(id));
	}

	@Override
	public List<BaseDto> findAllDto(BaseDto filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagedListHolder<BaseDto> findUsersPagedByCriteria(BaseDto searchBean, int i,
			Integer displayTagObjectsPerPage, String sort, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}
}
