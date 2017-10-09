package com.vince.boot.demo.webapp.fe.dto;

public class RoleFunctionFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private RoleUserFe DRoleUser;

	public RoleFunctionFe() {
	}

	public RoleUserFe getDRoleUser() {
		return this.DRoleUser;
	}

	public void setDRoleUser(RoleUserFe DRoleUser) {
		this.DRoleUser = DRoleUser;
	}

}
