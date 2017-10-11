package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.RoleFunction;

public class RoleFunctionDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	private RoleUserDto roleUser;

	public RoleFunctionDto() {
	}

	public RoleUserDto getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(RoleUserDto DRoleUser) {
		this.roleUser = DRoleUser;
	}

	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public RoleFunctionDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		RoleFunctionDto dto = new RoleFunctionDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public RoleFunction createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		RoleFunction entity = new RoleFunction();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


}
