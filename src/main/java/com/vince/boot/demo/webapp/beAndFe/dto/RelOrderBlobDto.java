package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelOrderBlob;

public class RelOrderBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private OrderJobDto DOrderJob;
	private BlobStoreDto DBlobStore;

	public RelOrderBlobDto() {
	}

	public OrderJobDto getDOrderJob() {
		return this.DOrderJob;
	}

	public void setDOrderJob(OrderJobDto DOrderJob) {
		this.DOrderJob = DOrderJob;
	}

	public BlobStoreDto getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreDto DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

	/*
	 * CONVERTER ENTITY <--> DTO
	 */
	public static BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		RelOrderBlobDto dto = new RelOrderBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		RelOrderBlob entity = new RelOrderBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
