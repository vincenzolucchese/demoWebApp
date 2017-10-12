package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelOrderBlob;

public class RelOrderBlobDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	private OrderJobDto orderJob;
	private BlobStoreDto blobStore;

	public RelOrderBlobDto() {
	}

	public OrderJobDto getOrderJob() {
		return this.orderJob;
	}

	public void setOrderJob(OrderJobDto DOrderJob) {
		this.orderJob = DOrderJob;
	}

	public BlobStoreDto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreDto DBlobStore) {
		this.blobStore = DBlobStore;
	}
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static RelOrderBlobDto createDtoFromEntity(RelOrderBlob entity) {
		if (entity == null) return null;
		RelOrderBlobDto dto = new RelOrderBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static RelOrderBlob createEntityFromDto(RelOrderBlobDto dto) {
		if (dto == null) return null;
		RelOrderBlob entity = new RelOrderBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}



}
