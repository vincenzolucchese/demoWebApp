package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.SystemProps;

public class SystemPropsDto extends BaseDto  {

	private static final long serialVersionUID = 1L;

	private String keyProp;
	private String valueProp;

	public SystemPropsDto() {
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
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static SystemPropsDto createDtoFromEntity(SystemProps entity) {
		if (entity == null) return null;
		SystemPropsDto dto = new SystemPropsDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static SystemProps createEntityFromDto(SystemPropsDto dto) {
		if (dto == null) return null;
		SystemProps entity = new SystemProps();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
