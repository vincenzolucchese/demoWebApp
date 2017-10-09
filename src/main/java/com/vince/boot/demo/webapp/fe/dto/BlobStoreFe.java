package com.vince.boot.demo.webapp.fe.dto;


import java.util.HashSet;
import java.util.Set;


public class BlobStoreFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private TypeDocumentFe DTypeDocument;

	private String filename;
	private char flagActive;
	private byte[] blobData;
	private String description;
	private String contentType;

	private Set<RelOrderBlobFe> DRelOrderBlobs = new HashSet<RelOrderBlobFe>(0);
	private Set<RelUserBlobFe> DRelUserBlobs = new HashSet<RelUserBlobFe>(0);
	private Set<RelClientBlobFe> DRelClientBlobs = new HashSet<RelClientBlobFe>(0);

	public BlobStoreFe() {
	}

	public TypeDocumentFe getDTypeDocument() {
		return this.DTypeDocument;
	}

	public void setDTypeDocument(TypeDocumentFe DTypeDocument) {
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

	public Set<RelOrderBlobFe> getDRelOrderBlobs() {
		return this.DRelOrderBlobs;
	}

	public void setDRelOrderBlobs(Set<RelOrderBlobFe> DRelOrderBlobs) {
		this.DRelOrderBlobs = DRelOrderBlobs;
	}

	public Set<RelUserBlobFe> getDRelUserBlobs() {
		return this.DRelUserBlobs;
	}

	public void setDRelUserBlobs(Set<RelUserBlobFe> DRelUserBlobs) {
		this.DRelUserBlobs = DRelUserBlobs;
	}

	public Set<RelClientBlobFe> getDRelClientBlobs() {
		return this.DRelClientBlobs;
	}

	public void setDRelClientBlobs(Set<RelClientBlobFe> DRelClientBlobs) {
		this.DRelClientBlobs = DRelClientBlobs;
	}

}
