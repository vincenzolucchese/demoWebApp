package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.DClientApp;
import com.vince.boot.demo.webapp.be.entity.DTypeDocument;


public interface DTypeDocumentRepository extends JpaRepository<DTypeDocument, Long>, QueryDslPredicateExecutor<DTypeDocument> {

	
}
