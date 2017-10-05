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
package com.vince.boot.demo.webapp.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component("commonAppRepositoryImpl")
public class CommonAppRepositoryImpl extends JdbcDaoSupport {

	private static final Logger logger = LoggerFactory.getLogger(CommonAppRepositoryImpl.class);
	private static final String GET_SYSDATE_SQL = "SELECT SYSDATE()";
	
	@PersistenceContext 
	private EntityManager em;

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

	public Date getSysdateFromDBJdbc() {
		logger.debug("JDBC");
		return getJdbcTemplate().queryForObject(GET_SYSDATE_SQL, Date.class);
	}
	
}
