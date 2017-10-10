package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.ClientApp;


public interface ClientAppRepository extends JpaRepository<ClientApp, Long>, QueryDslPredicateExecutor<ClientApp> {

	
}
