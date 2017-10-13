package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.RelClientBlob;
import com.vince.boot.demo.webapp.be.entity.RelOrderBlob;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;
import com.vince.boot.demo.webapp.be.entity.RoleUser;


public interface RelOrderBlobRepository extends JpaRepository<RelOrderBlob, Long>, QueryDslPredicateExecutor<RelOrderBlob> {

	RelOrderBlob findByBlobStore_idAndOrderJob_id(Long idBlob, Long idOrderJob);
}
