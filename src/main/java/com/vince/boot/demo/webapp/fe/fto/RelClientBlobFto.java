package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RelClientBlobDto;

public class RelClientBlobFto extends BaseFto  {

	private static final long serialVersionUID = 1L;
	private ClientAppFto clientApp;
	private BlobStoreFto blobStore;

	public RelClientBlobFto() {
	}

	public ClientAppFto getClientApp() {
		return this.clientApp;
	}

	public void setClientApp(ClientAppFto DClientApp) {
		this.clientApp = DClientApp;
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
		
		RelClientBlobFto fto = new RelClientBlobFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		RelClientBlobDto dto = new RelClientBlobDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}

}
