package com.vince.boot.demo.webapp.service;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Service;

import com.vince.boot.demo.webapp.entity.BaseEntity;


@Service
public interface CommonAppRepository extends JpaRepository<BaseEntity, Long>, QueryDslPredicateExecutor<BaseEntity>{

//	public Date getSysdateFromDB();
}
