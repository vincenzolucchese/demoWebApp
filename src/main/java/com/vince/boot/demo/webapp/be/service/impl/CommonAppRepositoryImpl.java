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
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.OrderJob;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;
import com.vince.boot.demo.webapp.be.entity.RelOrderBlob;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;
import com.vince.boot.demo.webapp.be.entity.RoleUser;
import com.vince.boot.demo.webapp.be.entity.TypeDocument;
import com.vince.boot.demo.webapp.be.entity.UserApp;
import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;
import com.vince.boot.demo.webapp.be.service.ClientAppRepository;
import com.vince.boot.demo.webapp.be.service.CommonDtoRepository;
import com.vince.boot.demo.webapp.be.service.OrderJobRepository;
import com.vince.boot.demo.webapp.be.service.RelClientBlobRepository;
import com.vince.boot.demo.webapp.be.service.RelOrderBlobRepository;
import com.vince.boot.demo.webapp.be.service.RelUserBlobRepository;
import com.vince.boot.demo.webapp.be.service.RoleUserRepository;
import com.vince.boot.demo.webapp.be.service.TypeDocumentRepository;
import com.vince.boot.demo.webapp.be.service.UserAppRepository;
import com.vince.boot.demo.webapp.be.utility.PageableUtils;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;
import com.vince.boot.demo.webapp.beAndFe.dto.ClientAppDto;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;
import com.vince.boot.demo.webapp.beAndFe.dto.TypeDocumentDto;
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
	@Autowired
	RoleUserRepository roleUserRepository;
	@Autowired
	RelUserBlobRepository relUserBlobRepository;
	@Autowired
	RelOrderBlobRepository relOrderBlobRepository;
	@Autowired
	RelClientBlobRepository relClientBlobRepository;

	
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
	public BlobStoreDto saveBlobStoreDto(BlobStoreDto entityDto, String username) throws IOException {
		BlobStore entity = BlobStoreDto.createEntityFromDto(entityDto);
		//FIXME: to dynamic
		entity.setTypeDocument(typeDocumentRepository.findOne(new Long(1)));
		Date dateDB = getSysdateFromDBJdbc();
		entity.setTimeInsert(dateDB);
		entity.setYearRefer(dateDB);
		entity.setUserInsert(username);
		return BlobStoreDto.createDtoFromEntity(blobStoreRepository.save(entity));
	}
	
	/**
	 * Save a simple DTO that has some Blob relation
	 * during UPDATE verify that relation exist for removing from persistence and avoid
	 * multiply of relations
	 */
	@Override
	public UserAppDto saveUserAppDto(UserAppDto entityDto, String currentUsername, List<BlobStoreDto> listBlobs) throws IOException {
		UserApp entity = UserAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		
		for (BlobStoreDto eachBlob : listBlobs) {
			if(eachBlob.getId()!=null) {				
				entity.getRelUserBlobs().add(new RelUserBlob(entity, new BlobStore(eachBlob.getId())));				
			}
		}				
		if(entity.isNew()){
			entity.setUserInsert(currentUsername);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			UserApp temp = userAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			if(entity.getRelUserBlobs()!=null) {
				HashSet<RelUserBlob> hashTemp = new HashSet<RelUserBlob>();
				for (RelUserBlob eachRel : entity.getRelUserBlobs()) {
					RelUserBlob tempRel = relUserBlobRepository.findByBlobStore_idAndUserApp_id(eachRel.getBlobStore().getId(), temp.getId());
					if(tempRel==null) {
						hashTemp.add(eachRel);
					}
				}
				entity.setRelUserBlobs(hashTemp);
			}
			
			entity.setUserUpdate(currentUsername);
			entity.setTimeUpdate(dateDB);
		}		
		entity = userAppRepository.save(entity);
		return UserAppDto.createDtoFromEntity(entity);
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
	
	
	/**
	 * Save a simple DTO that has some Blob relation
	 * during UPDATE verify that relation exist for removing from persistence and avoid
	 * multiply of relations
	 */
	@Override
	public ClientAppDto saveClientAppDto(ClientAppDto entityDto, String currentUsername, List<BlobStoreDto> listBlobs) throws IOException {
		ClientApp entity = ClientAppDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		
		for (BlobStoreDto eachBlob : listBlobs) {
			if(eachBlob.getId()!=null) {				
				entity.getRelClientBlobs().add(new RelClientBlob(entity, new BlobStore(eachBlob.getId())));				
			}
		}				
		if(entity.isNew()){
			entity.setUserInsert(currentUsername);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			ClientApp temp = clientAppRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			if(entity.getRelClientBlobs()!=null) {
				HashSet<RelClientBlob> hashTemp = new HashSet<RelClientBlob>();
				for (RelClientBlob eachRel : entity.getRelClientBlobs()) {
					RelClientBlob tempRel = relClientBlobRepository.findByBlobStore_idAndClientApp_id(eachRel.getBlobStore().getId(), temp.getId());
					if(tempRel==null) {
						hashTemp.add(eachRel);
					}
				}
				entity.setRelClientBlobs(hashTemp);
			}
			
			entity.setUserUpdate(currentUsername);
			entity.setTimeUpdate(dateDB);
		}		
		entity = clientAppRepository.save(entity);
		return ClientAppDto.createDtoFromEntity(entity);
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
	
	/**
	 * Save a simple DTO that has some Blob relation
	 * during UPDATE verify that relation exist for removing from persistence and avoid
	 * multiply of relations
	 */
	@Override
	public OrderJobDto saveOrderJobDto(OrderJobDto entityDto, String currentUsername, List<BlobStoreDto> listBlobs) throws IOException {
		OrderJob entity = OrderJobDto.createEntityFromDto(entityDto);
		Date dateDB = getSysdateFromDBJdbc();
		
		for (BlobStoreDto eachBlob : listBlobs) {
			if(eachBlob.getId()!=null) {				
				entity.getRelOrderBlobs().add(new RelOrderBlob(entity, new BlobStore(eachBlob.getId())));				
			}
		}				
		if(entity.isNew()){
			entity.setUserInsert(currentUsername);
			entity.setTimeInsert(dateDB);
			entity.setYearRefer(dateDB);
		}else {
			OrderJob temp = orderJobRepository.findOne(entity.getId());
			entity.setUserInsert(temp.getUserInsert());
			entity.setTimeInsert(temp.getTimeInsert());
			entity.setYearRefer(temp.getYearRefer());
			
			if(entity.getRelOrderBlobs()!=null) {
				HashSet<RelOrderBlob> hashTemp = new HashSet<RelOrderBlob>();
				for (RelOrderBlob eachRel : entity.getRelOrderBlobs()) {
					RelOrderBlob tempRel = relOrderBlobRepository.findByBlobStore_idAndOrderJob_id(eachRel.getBlobStore().getId(), temp.getId());
					if(tempRel==null) {
						hashTemp.add(eachRel);
					}
				}	
				entity.setRelOrderBlobs(hashTemp);
			}
			
			entity.setUserUpdate(currentUsername);
			entity.setTimeUpdate(dateDB);
		}		
		entity = orderJobRepository.save(entity);
		return OrderJobDto.createDtoFromEntity(entity);
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
		if (entitiesDto == null) {
			return null;
		}
		List<OrderJobDto> result = new ArrayList<OrderJobDto>();
		for (OrderJobDto each : entitiesDto) {
			result.add(saveOrderJobDto(each, USER_SYSTEM, getSysdateFromDBJdbc()));
		}
		return result;
	}

	@Override
	public List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user) {
		if (entitiesDto == null) {
			return null;
		}
		List<OrderJobDto> result = new ArrayList<OrderJobDto>();
		for (OrderJobDto each : entitiesDto) {
			result.add(saveOrderJobDto(each, user, getSysdateFromDBJdbc()));
		}
		return result;
	}

	@Override
	public List<OrderJobDto> saveOrderJobDto(Iterable<OrderJobDto> entitiesDto, String user, Date date) {
		if (entitiesDto == null) {
			return null;
		}
		List<OrderJobDto> result = new ArrayList<OrderJobDto>();
		for (OrderJobDto each : entitiesDto) {
			result.add(saveOrderJobDto(each, user, date));
		}
		return result;
	}

	@Override
	public OrderJobDto findOneDto(OrderJobDto filter) {
		OrderJob entity = OrderJobDto.createEntityFromDto(filter);
		Example<OrderJob> example = Example.of(entity);
		return OrderJobDto.createDtoFromEntity(orderJobRepository.findOne(example));
	}

	@Override
	public List<OrderJobDto> findAllDto(OrderJobDto filter) {
		OrderJob entity = OrderJobDto.createEntityFromDto(filter);
		Example<OrderJob> example = Example.of(entity);
		List<OrderJob> listEntity = orderJobRepository.findAll(example);
		if(listEntity==null){
			return null;
		}
		List<OrderJobDto> lista = new ArrayList<OrderJobDto>();
		for (OrderJob each : listEntity) {
			lista.add(OrderJobDto.createDtoFromEntity(each));
		}
		return lista;
	}

	@Override
	public PagedListHolder<OrderJobDto> findDtoPagedByCriteria(OrderJobDto searchBean, int i,
			Integer displayTagObjectsPerPage, String sort, boolean b) {
		Pageable pageable = PageableUtils.constructPageSpecification(i, displayTagObjectsPerPage.intValue(), sort, Boolean.valueOf(b));
		Page<OrderJob> entityPage = null;

		OrderJob entity = OrderJobDto.createEntityFromDto(searchBean);
		Example<OrderJob> example = Example.of(entity);
		entityPage = orderJobRepository.findAll(example, pageable);
		
		if(entityPage == null) {
			return null;
		}
		ArrayList<OrderJobDto> listaDto = new ArrayList<OrderJobDto>();
		for (OrderJob eachEntity : entityPage) {
			listaDto.add(OrderJobDto.createDtoFromEntity(eachEntity));
		}
		PagedListHolder<OrderJobDto> beanPage = new PagedListHolder<OrderJobDto>(listaDto);
		return beanPage;
	}

	@Override
	public Long deleteDto(OrderJobDto entityDto) {
		OrderJob entity = OrderJobDto.createEntityFromDto(entityDto);
		if(entity.getId()!=null){
			orderJobRepository.delete(entity.getId());
		}else{
			orderJobRepository.delete(entity);			
		}		
		return null;
	}
	
	@Override
	public BlobStoreDto findOneBlobStoreDto(Long id) {
		return BlobStoreDto.createDtoFromEntity(blobStoreRepository.findOne(id));
	}

	@Override
	public UserAppDto findOneUserAppDto(Long id) {
		return UserAppDto.createDtoFromEntity(userAppRepository.findOne(id));
	}

	@Override
	public ClientAppDto findOneClientAppDto(Long id) {
		return ClientAppDto.createDtoFromEntity(clientAppRepository.findOne(id));
	}

	@Override
	public OrderJobDto findOneOrderJobDto(Long id) {
		return OrderJobDto.createDtoFromEntity(orderJobRepository.findOne(id));
	}

	@Override
	public RoleUserDto findOneRoleUserDto(Long id) {
		return RoleUserDto.createDtoFromEntity(roleUserRepository.findOne(id));
	}

	@Override
	public List<RoleUserDto> findAllDto(RoleUserDto filter) {
		RoleUser entity = RoleUserDto.createEntityFromDto(filter);
		Example<RoleUser> example = Example.of(entity);
		List<RoleUser> listEntity = roleUserRepository.findAll(example);
		if(listEntity==null){
			return null;
		}
		List<RoleUserDto> lista = new ArrayList<RoleUserDto>();
		for (RoleUser each : listEntity) {
			lista.add(RoleUserDto.createDtoFromEntity(each));
		}
		return lista;
	}

	@Override
	public TypeDocumentDto findOneTypeDocumentDto(Long id) {
		return TypeDocumentDto.createDtoFromEntity(typeDocumentRepository.findOne(id));
	}

	@Override
	public List<TypeDocumentDto> findAllDto(TypeDocumentDto filter) {
		TypeDocument entity = TypeDocumentDto.createEntityFromDto(filter);
		Example<TypeDocument> example = Example.of(entity);
		List<TypeDocument> listEntity = typeDocumentRepository.findAll(example);
		if(listEntity==null){
			return null;
		}
		List<TypeDocumentDto> lista = new ArrayList<TypeDocumentDto>();
		for (TypeDocument each : listEntity) {
			lista.add(TypeDocumentDto.createDtoFromEntity(each));
		}
		return lista;
	}

	@Override
	public Long deleteDto(BlobStoreDto entityDto) throws IOException {
		BlobStore entity = new BlobStore(entityDto.getId());
		if(entity.getId()!=null){
			blobStoreRepository.delete(entity.getId());
		}else{
			blobStoreRepository.delete(entity);			
		}		
		return null;
	}


}
