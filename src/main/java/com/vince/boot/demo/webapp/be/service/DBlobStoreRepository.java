package com.vince.boot.demo.webapp.be.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.DBlobStore;
import com.vince.boot.demo.webapp.be.entity.DClientApp;
import com.vince.boot.demo.webapp.be.entity.DOrderJob;
import com.vince.boot.demo.webapp.be.entity.DUserApp;

public interface DBlobStoreRepository extends JpaRepository<DBlobStore, Long>, QueryDslPredicateExecutor<DBlobStore> {
//
//	List<DBlobStore> findByFlagActiveAndDRelClientBlobs_Client(char flag, DClientApp client);
//	
//	List<DBlobStore> findByFlagActiveAndDRelUserBlobs_User(char flag, DUserApp user);
//	
//	List<DBlobStore> findByFlagActiveAndDRelOrderBlobs_Order(char flag, DOrderJob order);
}
