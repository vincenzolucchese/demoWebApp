package com.vince.boot.demo.webapp.beAndFe.dto;

public class RoleFunctionDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private RoleUserDto DRoleUser;

	public RoleFunctionDto() {
	}

	public RoleUserDto getDRoleUser() {
		return this.DRoleUser;
	}

	public void setDRoleUser(RoleUserDto DRoleUser) {
		this.DRoleUser = DRoleUser;
	}

}
