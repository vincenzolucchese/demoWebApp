package com.vince.boot.demo.webapp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.entity.BaseEntity;


public interface CommonAppRepository extends JpaRepository<BaseEntity, Long>, QueryDslPredicateExecutor<BaseEntity> {

}
