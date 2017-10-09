package com.vince.boot.demo.webapp.fe.dto;

import java.util.HashSet;
import java.util.Set;

public class TypeDocumentFe extends BaseFe {

	private static final long serialVersionUID = 1L;

	private String typeCode;
	private String typeDescription;

	private Set<BlobStoreFe> DBlobStores = new HashSet<BlobStoreFe>(0);

	public TypeDocumentFe() {
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

	public Set<BlobStoreFe> getDBlobStores() {
		return this.DBlobStores;
	}

	public void setDBlobStores(Set<BlobStoreFe> DBlobStores) {
		this.DBlobStores = DBlobStores;
	}

}
