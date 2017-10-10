package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelOrderBlobDto  {

	private static final long serialVersionUID = 1L;
	private OrderJobDto orderJob;
	private BlobStoreDto blobStore;

	public RelOrderBlobDto() {
	}

	public OrderJobDto getOrderJob() {
		return this.orderJob;
	}

	public void setOrderJob(OrderJobDto DOrderJob) {
		this.orderJob = DOrderJob;
	}

	public BlobStoreDto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreDto DBlobStore) {
		this.blobStore = DBlobStore;
	}



}
