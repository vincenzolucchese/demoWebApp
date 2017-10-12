package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RelOrderBlobDto;

public class RelOrderBlobFto extends BaseFto  {

	private static final long serialVersionUID = 1L;
	private OrderJobFto orderJob;
	private BlobStoreFto blobStore;

	public RelOrderBlobFto() {
	}

	public OrderJobFto getOrderJob() {
		return this.orderJob;
	}

	public void setOrderJob(OrderJobFto DOrderJob) {
		this.orderJob = DOrderJob;
	}

	public BlobStoreFto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreFto DBlobStore) {
		this.blobStore = DBlobStore;
	}
	
	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		RelOrderBlobFto fto = new RelOrderBlobFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		RelOrderBlobDto dto = new RelOrderBlobDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}



}
