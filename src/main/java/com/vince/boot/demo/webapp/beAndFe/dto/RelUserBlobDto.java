package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelUserBlobDto  {

	private static final long serialVersionUID = 1L;
	private BlobStoreDto blobStore;
	private UserAppDto userApp;

	public RelUserBlobDto() {
	}

	public BlobStoreDto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreDto DBlobStore) {
		this.blobStore = DBlobStore;
	}

	public UserAppDto getUserApp() {
		return this.userApp;
	}

	public void setUserApp(UserAppDto DUserApp) {
		this.userApp = DUserApp;
	}


}
