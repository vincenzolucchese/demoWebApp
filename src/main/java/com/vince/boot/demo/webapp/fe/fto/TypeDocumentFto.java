package com.vince.boot.demo.webapp.fe.fto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.TypeDocumentDto;

public class TypeDocumentFto extends BaseFto {

	private static final long serialVersionUID = 1L;

	private String typeCode;
	private String typeDescription;

	private Set<BlobStoreFto> DBlobStores = new HashSet<BlobStoreFto>(0);

	public TypeDocumentFto() {
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

	public Set<BlobStoreFto> getDBlobStores() {
		return this.DBlobStores;
	}

	public void setDBlobStores(Set<BlobStoreFto> DBlobStores) {
		this.DBlobStores = DBlobStores;
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		TypeDocumentFto fto = new TypeDocumentFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		TypeDocumentDto dto = new TypeDocumentDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}
	
	
	

}
