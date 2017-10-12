package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.SystemPropsDto;

public class SystemPropsFto extends BaseFto  {

	private static final long serialVersionUID = 1L;

	private String keyProp;
	private String valueProp;

	public SystemPropsFto() {
	}

	public String getKeyProp() {
		return this.keyProp;
	}

	public void setKeyProp(String keyProp) {
		this.keyProp = keyProp;
	}

	public String getValueProp() {
		return this.valueProp;
	}

	public void setValueProp(String valueProp) {
		this.valueProp = valueProp;
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		SystemPropsFto fto = new SystemPropsFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		SystemPropsDto dto = new SystemPropsDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}

}
