package com.vince.boot.demo.webapp.beAndFe.dto;

public class RelOrderBlobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private OrderJobDto DOrderJob;
	private BlobStoreDto DBlobStore;

	public RelOrderBlobDto() {
	}

	public OrderJobDto getDOrderJob() {
		return this.DOrderJob;
	}

	public void setDOrderJob(OrderJobDto DOrderJob) {
		this.DOrderJob = DOrderJob;
	}

	public BlobStoreDto getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(BlobStoreDto DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

}
