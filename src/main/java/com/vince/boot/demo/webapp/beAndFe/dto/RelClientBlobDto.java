package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;

public class RelClientBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private ClientAppDto DClientApp;
	private BlobStoreDto DBlobStore;

	public RelClientBlobDto() {
	}

	public ClientAppDto getDClientApp() {
		return this.DClientApp;
	}

	public void setDClientApp(ClientAppDto DClientApp) {
		this.DClientApp = DClientApp;
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
		RelClientBlobDto dto = new RelClientBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		RelClientBlob entity = new RelClientBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
