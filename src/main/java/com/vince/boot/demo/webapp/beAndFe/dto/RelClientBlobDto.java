package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelClientBlobDto {

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



}
