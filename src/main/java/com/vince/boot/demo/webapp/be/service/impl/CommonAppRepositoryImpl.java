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
import com.vince.boot.demo.webapp.be.entity.TypeDocument;
import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.BaseEntityToDtoRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.ClientAppRepository;
import com.vince.boot.demo.webapp.be.service.TypeDocumentRepository;
import com.vince.boot.demo.webapp.be.utility.PageableUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;

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
	public Long deleteDto(BaseDto entityDto) {
		BaseEntity entity = entityDto.createEntityFromDto(entityDto);
		baseEntityRepository.delete(entity);
		return 1l;
	}
}
