package com.vince.boot.demo.webapp.fe.dto;

import java.util.HashSet;
import java.util.Set;

public class RoleUserFe extends BaseFe {

	private static final long serialVersionUID = 1L;

	private String roleCode;
	private String roleDescription;

	private Set<UserAppFe> DUserApps = new HashSet<UserAppFe>(0);
	private Set<RoleFunctionFe> DRoleFunctions = new HashSet<RoleFunctionFe>(0);

	public RoleUserFe() {
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

	public Set<UserAppFe> getDUserApps() {
		return this.DUserApps;
	}

	public void setDUserApps(Set<UserAppFe> DUserApps) {
		this.DUserApps = DUserApps;
	}

	public Set<RoleFunctionFe> getDRoleFunctions() {
		return this.DRoleFunctions;
	}

	public void setDRoleFunctions(Set<RoleFunctionFe> DRoleFunctions) {
		this.DRoleFunctions = DRoleFunctions;
	}

}
