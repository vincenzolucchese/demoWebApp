package com.vince.boot.demo.webapp.fe.fto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;

public class RoleUserFto extends BaseFto {

	private static final long serialVersionUID = 1L;
	private String roleCode;
	private String roleDescription;

	private Set<UserAppFto> userApps = new HashSet<UserAppFto>(0);
	private Set<RoleFunctionFto> roleFunctions = new HashSet<RoleFunctionFto>(0);

	public RoleUserFto() {
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

	public Set<UserAppFto> getUserApps() {
		return this.userApps;
	}

	public void setUserApps(Set<UserAppFto> userApps) {
		this.userApps = userApps;
	}

	public Set<RoleFunctionFto> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunctionFto> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
	
	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static RoleUserFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		RoleUserFto fto = new RoleUserFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static RoleUserDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		RoleUserDto dto = new RoleUserDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}




}
