package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.UserApp;


public interface UserAppRepository extends JpaRepository<UserApp, Long>, QueryDslPredicateExecutor<UserApp> {

	
}
