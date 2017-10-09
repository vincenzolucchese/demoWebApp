package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

public class RoleUserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String roleCode;
	private String roleDescription;

	private Set<UserAppDto> DUserApps = new HashSet<UserAppDto>(0);
	private Set<RoleFunctionDto> DRoleFunctions = new HashSet<RoleFunctionDto>(0);

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

	public Set<UserAppDto> getDUserApps() {
		return this.DUserApps;
	}

	public void setDUserApps(Set<UserAppDto> DUserApps) {
		this.DUserApps = DUserApps;
	}

	public Set<RoleFunctionDto> getDRoleFunctions() {
		return this.DRoleFunctions;
	}

	public void setDRoleFunctions(Set<RoleFunctionDto> DRoleFunctions) {
		this.DRoleFunctions = DRoleFunctions;
	}

}
