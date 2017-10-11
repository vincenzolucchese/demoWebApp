package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.GeoLocal;

public class RoleUserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String roleCode;
	private String roleDescription;

	private Set<UserAppDto> userApps = new HashSet<UserAppDto>(0);
	private Set<RoleFunctionDto> roleFunctions = new HashSet<RoleFunctionDto>(0);

	public RoleUserDto() {
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<UserAppDto> getUserApps() {
		return this.userApps;
	}

	public void setUserApps(Set<UserAppDto> userApps) {
		this.userApps = userApps;
	}

	public Set<RoleFunctionDto> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunctionDto> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public RoleUserDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		RoleUserDto dto = new RoleUserDto();
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
