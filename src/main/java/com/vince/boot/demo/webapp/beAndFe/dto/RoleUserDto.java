package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

public class RoleUserDto  {

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

	public void setUserApps(Set<UserAppDto> DUserApps) {
		this.userApps = DUserApps;
	}

	public Set<RoleFunctionDto> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunctionDto> DRoleFunctions) {
		this.roleFunctions = DRoleFunctions;
	}


}
