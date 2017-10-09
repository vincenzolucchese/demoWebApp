package com.vince.boot.demo.webapp.be.service;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.vince.boot.demo.webapp.be.entity.DBlobStore;
import com.vince.boot.demo.webapp.be.entity.DClientApp;
import com.vince.boot.demo.webapp.be.entity.DOrderJob;
import com.vince.boot.demo.webapp.be.entity.DUserApp;

public interface BlobStoreRepository extends CrudRepository<DBlobStore, Long>, QueryDslPredicateExecutor<DBlobStore> {

	List<DBlobStore> findByFlagActiveAndDRelClientBlobs_DClientApp(char flag, DClientApp client);
	
	List<DBlobStore> findByFlagActiveAndDRelUserBlobs_DUserApp(char flag, DUserApp user);
	
	List<DBlobStore> findByFlagActiveAndDRelOrderBlobs_DOrderJob(char flag, DOrderJob order);
}
