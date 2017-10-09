package com.vince.boot.demo.webapp.beAndFe.dto;


import java.util.HashSet;
import java.util.Set;


public class BlobStoreDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private TypeDocumentDto DTypeDocument;

	private String filename;
	private char flagActive;
	private byte[] blobData;
	private String description;
	private String contentType;

	private Set<RelOrderBlobDto> DRelOrderBlobs = new HashSet<RelOrderBlobDto>(0);
	private Set<RelUserBlobDto> DRelUserBlobs = new HashSet<RelUserBlobDto>(0);
	private Set<RelClientBlobDto> DRelClientBlobs = new HashSet<RelClientBlobDto>(0);

	public BlobStoreDto() {
	}

	public TypeDocumentDto getDTypeDocument() {
		return this.DTypeDocument;
	}

	public void setDTypeDocument(TypeDocumentDto DTypeDocument) {
		this.DTypeDocument = DTypeDocument;
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

	public Set<RelOrderBlobDto> getDRelOrderBlobs() {
		return this.DRelOrderBlobs;
	}

	public void setDRelOrderBlobs(Set<RelOrderBlobDto> DRelOrderBlobs) {
		this.DRelOrderBlobs = DRelOrderBlobs;
	}

	public Set<RelUserBlobDto> getDRelUserBlobs() {
		return this.DRelUserBlobs;
	}

	public void setDRelUserBlobs(Set<RelUserBlobDto> DRelUserBlobs) {
		this.DRelUserBlobs = DRelUserBlobs;
	}

	public Set<RelClientBlobDto> getDRelClientBlobs() {
		return this.DRelClientBlobs;
	}

	public void setDRelClientBlobs(Set<RelClientBlobDto> DRelClientBlobs) {
		this.DRelClientBlobs = DRelClientBlobs;
	}

}
