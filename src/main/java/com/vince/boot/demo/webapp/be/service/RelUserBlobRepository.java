package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.RelUserBlob;
import com.vince.boot.demo.webapp.be.entity.RoleUser;


public interface RelUserBlobRepository extends JpaRepository<RelUserBlob, Long>, QueryDslPredicateExecutor<RelUserBlob> {

	RelUserBlob findByBlobStore_idAndUserApp_id(Long idBlob, Long idUserApp);
}
