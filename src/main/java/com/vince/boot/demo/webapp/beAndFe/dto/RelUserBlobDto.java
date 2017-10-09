package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelUserBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private BlobStoreDto DBlobStore;
	private UserAppDto DUserApp;

	public RelUserBlobDto() {
	}

	public BlobStoreDto getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreDto DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

	public UserAppDto getDUserApp() {
		return this.DUserApp;
	}

	public void setDUserApp(UserAppDto DUserApp) {
		this.DUserApp = DUserApp;
	}

}
