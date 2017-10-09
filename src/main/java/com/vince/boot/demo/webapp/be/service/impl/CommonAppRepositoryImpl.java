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
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.service.BaseEntityRepository;
import com.vince.boot.demo.webapp.be.service.BlobStoreRepository;

/**
 * Bean Service for common custom implementation about all web app
 * @author Vincenzo
 *
 */
@Component("commonAppRepositoryImpl")
public class CommonAppRepositoryImpl extends JdbcDaoSupport {

	private static final Logger logger = LoggerFactory.getLogger(CommonAppRepositoryImpl.class);
	private static final String GET_SYSDATE_SQL = "SELECT SYSDATE()";
	
	@PersistenceContext 
	private EntityManager em;
	
	@Autowired
	BaseEntityRepository baseEntityService;
	@Autowired
	BlobStoreRepository blobStoreService;

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
		return baseEntityService.save(entity);
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
		return baseEntityService.save(entity);
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
	
	


	
	

	
}
