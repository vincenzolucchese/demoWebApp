package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;

public class RelUserBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private BlobStoreDto DBlobStore;
	private UserAppDto DUserApp;

	public RelUserBlobDto() {
	}

	public BlobStoreDto getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreDto DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

	public UserAppDto getDUserApp() {
		return this.DUserApp;
	}

	public void setDUserApp(UserAppDto DUserApp) {
		this.DUserApp = DUserApp;
	}

	/*
	 * CONVERTER ENTITY <--> DTO
	 */
	public static BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		RelUserBlobDto dto = new RelUserBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		RelUserBlob entity = new RelUserBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
