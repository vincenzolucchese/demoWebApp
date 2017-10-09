package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

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

}
