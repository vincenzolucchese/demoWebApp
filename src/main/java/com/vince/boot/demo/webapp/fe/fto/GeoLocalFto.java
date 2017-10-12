package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.GeoLocalDto;

public class GeoLocalFto  extends BaseFto {

	private static final long serialVersionUID = 1L;

	public GeoLocalFto() {
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		GeoLocalFto fto = new GeoLocalFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		GeoLocalDto dto = new GeoLocalDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}



}
