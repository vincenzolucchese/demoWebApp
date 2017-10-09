package com.vince.boot.demo.webapp.fe.dto;

public class RelUserBlobFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private BlobStoreFe DBlobStore;
	private UserAppFe DUserApp;

	public RelUserBlobFe() {
	}

	public BlobStoreFe getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreFe DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

	public UserAppFe getDUserApp() {
		return this.DUserApp;
	}

	public void setDUserApp(UserAppFe DUserApp) {
		this.DUserApp = DUserApp;
	}

}
