package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.TypeDocument;

public class TypeDocumentDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String typeCode;
	private String typeDescription;

	private Set<BlobStoreDto> DBlobStores = new HashSet<BlobStoreDto>(0);

	public TypeDocumentDto() {
	}

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	public Set<BlobStoreDto> getDBlobStores() {
		return this.DBlobStores;
	}

	public void setDBlobStores(Set<BlobStoreDto> DBlobStores) {
		this.DBlobStores = DBlobStores;
	}

	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static TypeDocumentDto createDtoFromEntity(TypeDocument entity) {
		if (entity == null) return null;
		TypeDocumentDto dto = new TypeDocumentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static TypeDocument createEntityFromDto(TypeDocumentDto dto) {
		if (dto == null) return null;
		TypeDocument entity = new TypeDocument();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}
	

	

}
