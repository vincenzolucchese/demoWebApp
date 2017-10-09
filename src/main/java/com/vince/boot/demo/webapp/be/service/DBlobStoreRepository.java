package com.vince.boot.demo.webapp.be.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.DBlobStore;

public interface DBlobStoreRepository extends JpaRepository<DBlobStore, Long>, QueryDslPredicateExecutor<DBlobStore> {
//
//	List<DBlobStore> findByFlagActiveAndDRelClientBlobs_Client(char flag, DClientApp client);
//	
//	List<DBlobStore> findByFlagActiveAndDRelUserBlobs_User(char flag, DUserApp user);
//	
//	List<DBlobStore> findByFlagActiveAndDRelOrderBlobs_Order(char flag, DOrderJob order);
}
