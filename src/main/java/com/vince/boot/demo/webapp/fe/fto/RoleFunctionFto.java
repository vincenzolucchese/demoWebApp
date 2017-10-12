package com.vince.boot.demo.webapp.fe.fto;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleFunctionDto;

public class RoleFunctionFto extends BaseFto  {

	private static final long serialVersionUID = 1L;
	private RoleUserFto roleUser;

	public RoleFunctionFto() {
	}

	public RoleUserFto getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(RoleUserFto DRoleUser) {
		this.roleUser = DRoleUser;
	}

	
	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		RoleFunctionFto fto = new RoleFunctionFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		RoleFunctionDto dto = new RoleFunctionDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}


}
