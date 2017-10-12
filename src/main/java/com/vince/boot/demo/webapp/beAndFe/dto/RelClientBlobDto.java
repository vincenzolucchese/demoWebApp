package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;

public class RelClientBlobDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	private ClientAppDto clientApp;
	private BlobStoreDto blobStore;

	public RelClientBlobDto() {
	}

	public ClientAppDto getClientApp() {
		return this.clientApp;
	}

	public void setClientApp(ClientAppDto DClientApp) {
		this.clientApp = DClientApp;
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
	public static RelClientBlobDto createDtoFromEntity(RelClientBlob entity) {
		if (entity == null) return null;
		RelClientBlobDto dto = new RelClientBlobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static RelClientBlob createEntityFromDto(RelClientBlobDto dto) {
		if (dto == null) return null;
		RelClientBlob entity = new RelClientBlob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
