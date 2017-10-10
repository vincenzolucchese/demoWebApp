package com.vince.boot.demo.webapp.be.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.OrderJob;
import com.vince.boot.demo.webapp.be.entity.UserApp;

public interface BlobStoreRepository extends JpaRepository<BlobStore, Long>, QueryDslPredicateExecutor<BlobStore> {

	List<BlobStore> findByFlagActiveAndRelClientBlobs_ClientApp(char flag, ClientApp client);
	
	List<BlobStore> findByFlagActiveAndRelUserBlobs_UserApp(char flag, UserApp user);
	
	List<BlobStore> findByFlagActiveAndRelOrderBlobs_OrderJob(char flag, OrderJob order);
}
