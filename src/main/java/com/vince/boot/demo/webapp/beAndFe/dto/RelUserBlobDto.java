package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;

public class RelUserBlobDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	private BlobStoreDto blobStore;
	private UserAppDto userApp;

	public RelUserBlobDto() {
	}

	public BlobStoreDto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreDto DBlobStore) {
		this.blobStore = DBlobStore;
	}

	public UserAppDto getUserApp() {
		return this.userApp;
	}

	public void setUserApp(UserAppDto DUserApp) {
		this.userApp = DUserApp;
	}
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public RelUserBlobDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		RelUserBlobDto dto = new RelUserBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public RelUserBlob createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		RelUserBlob entity = new RelUserBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


}
