package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.GeoLocal;

public class GeoLocalDto  extends BaseDto {

	private static final long serialVersionUID = 1L;

	public GeoLocalDto() {
	}

	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public GeoLocalDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		GeoLocalDto dto = new GeoLocalDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		GeoLocal entity = new GeoLocal();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


}
