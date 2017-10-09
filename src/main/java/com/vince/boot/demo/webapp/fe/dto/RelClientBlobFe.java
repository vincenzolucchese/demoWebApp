package com.vince.boot.demo.webapp.fe.dto;

public class RelClientBlobFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private ClientAppFe DClientApp;
	private BlobStoreFe DBlobStore;

	public RelClientBlobFe() {
	}

	public ClientAppFe getDClientApp() {
		return this.DClientApp;
	}

	public void setDClientApp(ClientAppFe DClientApp) {
		this.DClientApp = DClientApp;
	}

	public BlobStoreFe getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreFe DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

}
