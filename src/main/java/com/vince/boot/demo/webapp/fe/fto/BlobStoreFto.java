package com.vince.boot.demo.webapp.fe.fto;


import org.springframework.beans.BeanUtils;
import org.springframework.web.multipart.MultipartFile;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.BlobStoreDto;


public class BlobStoreFto extends BaseFto {

	private static final long serialVersionUID = 1L;
	private TypeDocumentFto typeDocument;
	private String filename;
	private char flagActive;
	private byte[] blobData;
	private String description;
	private String contentType;

	private MultipartFile file;
	
	
	public BlobStoreFto() {
	}

	public BlobStoreFto(Long id) {
		super.id = id;
	}

	public TypeDocumentFto getTypeDocument() {
		return this.typeDocument;
	}

	public void setTypeDocument(TypeDocumentFto typeDocument) {
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


	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BlobStoreFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		BlobStoreFto fto = new BlobStoreFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BlobStoreDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		BlobStoreDto dto = new BlobStoreDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}



}
