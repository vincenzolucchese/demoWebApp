package com.vince.boot.demo.webapp.beAndFe.dto;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.BlobStore;
import com.vince.boot.demo.webapp.be.entity.TypeDocument;


public class BlobStoreDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private TypeDocumentDto typeDocument;

	private String filename;
	private char flagActive;
	private byte[] blobData;
	private String description;
	private String contentType;

	private Set<RelOrderBlobDto> relOrderBlobs = new HashSet<RelOrderBlobDto>(0);
	private Set<RelUserBlobDto> relUserBlobs = new HashSet<RelUserBlobDto>(0);
	private Set<RelClientBlobDto> relClientBlobs = new HashSet<RelClientBlobDto>(0);

	public BlobStoreDto() {
	}

	public TypeDocumentDto getTypeDocument() {
		return this.typeDocument;
	}

	public void setTypeDocument(TypeDocumentDto typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public char getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(char flagActive) {
		this.flagActive = flagActive;
	}

	public byte[] getBlobData() {
		return this.blobData;
	}

	public void setBlobData(byte[] blobData) {
		this.blobData = blobData;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Set<RelOrderBlobDto> getRelOrderBlobs() {
		return this.relOrderBlobs;
	}

	public void setRelOrderBlobs(Set<RelOrderBlobDto> relOrderBlobs) {
		this.relOrderBlobs = relOrderBlobs;
	}

	public Set<RelUserBlobDto> getRelUserBlobs() {
		return this.relUserBlobs;
	}

	public void setRelUserBlobs(Set<RelUserBlobDto> relUserBlobs) {
		this.relUserBlobs = relUserBlobs;
	}

	public Set<RelClientBlobDto> getRelClientBlobs() {
		return this.relClientBlobs;
	}

	public void setRelClientBlobs(Set<RelClientBlobDto> relClientBlobs) {
		this.relClientBlobs = relClientBlobs;
	}

	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		BlobStore entityCast = (BlobStore) entity;
		
		BlobStoreDto dto = new BlobStoreDto();
		BeanUtils.copyProperties(entityCast, dto);		
		// copy objects
		dto.setTypeDocument((TypeDocumentDto) new TypeDocumentDto().createDtoFromEntity(entityCast.getTypeDocument()));
		return dto;
	}

	public BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		BlobStoreDto dtoCast = (BlobStoreDto) dto;
		
		BlobStore entity = new BlobStore();
		BeanUtils.copyProperties(dtoCast, entity);
		// copy objects
		entity.setTypeDocument((TypeDocument) new TypeDocumentDto().createEntityFromDto(dtoCast.getTypeDocument()));
		return entity;
	}

}
