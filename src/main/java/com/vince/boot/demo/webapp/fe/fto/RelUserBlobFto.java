package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RelUserBlobDto;

public class RelUserBlobFto extends BaseFto  {

	private static final long serialVersionUID = 1L;
	private BlobStoreFto blobStore;
	private UserAppFto userApp;

	public RelUserBlobFto() {
	}

	public BlobStoreFto getBlobStore() {
		return this.blobStore;
	}

	public void setBlobStore(BlobStoreFto DBlobStore) {
		this.blobStore = DBlobStore;
	}

	public UserAppFto getUserApp() {
		return this.userApp;
	}

	public void setUserApp(UserAppFto DUserApp) {
		this.userApp = DUserApp;
	}
	
	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		RelUserBlobFto fto = new RelUserBlobFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		RelUserBlobDto dto = new RelUserBlobDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}


}
