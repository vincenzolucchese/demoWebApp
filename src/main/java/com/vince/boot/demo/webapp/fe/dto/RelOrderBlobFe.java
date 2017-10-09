package com.vince.boot.demo.webapp.fe.dto;

public class RelOrderBlobFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private OrderJobFe DOrderJob;
	private BlobStoreFe DBlobStore;

	public RelOrderBlobFe() {
	}

	public OrderJobFe getDOrderJob() {
		return this.DOrderJob;
	}

	public void setDOrderJob(OrderJobFe DOrderJob) {
		this.DOrderJob = DOrderJob;
	}

	public BlobStoreFe getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreFe DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

}
