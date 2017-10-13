package com.vince.boot.demo.webapp.beAndFe.dto;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vince.boot.demo.webapp.be.entity.BlobStore;


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

	private MultipartFile multipartFile;

	
	public BlobStoreDto() {
	}

	public BlobStoreDto(Long id) {
		super.id = id;
	}
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static BlobStoreDto createDtoFromEntity(BlobStore entity) {
		if (entity == null) return null;
		
		BlobStoreDto dto = new BlobStoreDto();
		BeanUtils.copyProperties(entity, dto);		
		// copy objects
		
		dto.setTypeDocument(TypeDocumentDto.createDtoFromEntity(entity.getTypeDocument()));
		return dto;
	}

	public static BlobStore createEntityFromDto(BlobStoreDto dto) throws IOException {
		if (dto == null) return null;
		
		BlobStore entity = new BlobStore();
		BeanUtils.copyProperties(dto, entity);
		// copy objects
		entity.setBlobData(dto.getMultipartFile().getBytes());
		entity.setContentType(dto.getMultipartFile().getContentType());
		entity.setDescription(dto.getMultipartFile().getOriginalFilename());
		entity.setFilename(dto.getMultipartFile().getOriginalFilename());
		entity.setFlagActive('1');
		entity.setTypeDocument(TypeDocumentDto.createEntityFromDto(dto.getTypeDocument()));
		return entity;
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
	
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

}
