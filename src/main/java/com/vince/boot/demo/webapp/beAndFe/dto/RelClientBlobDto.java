package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelClientBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private ClientAppDto DClientApp;
	private BlobStoreDto DBlobStore;

	public RelClientBlobDto() {
	}

	public ClientAppDto getDClientApp() {
		return this.DClientApp;
	}

	public void setDClientApp(ClientAppDto DClientApp) {
		this.DClientApp = DClientApp;
	}

	public BlobStoreDto getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreDto DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

}
