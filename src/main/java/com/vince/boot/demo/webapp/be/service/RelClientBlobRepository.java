package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.RelClientBlob;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;
import com.vince.boot.demo.webapp.be.entity.RoleUser;


public interface RelClientBlobRepository extends JpaRepository<RelClientBlob, Long>, QueryDslPredicateExecutor<RelClientBlob> {

	RelClientBlob findByBlobStore_idAndClientApp_id(Long idBlob, Long idClientApp);
}
