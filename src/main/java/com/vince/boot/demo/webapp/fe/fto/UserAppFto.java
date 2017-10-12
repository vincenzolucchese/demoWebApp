package com.vince.boot.demo.webapp.fe.fto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.RoleUserDto;
import com.vince.boot.demo.webapp.beAndFe.dto.UserAppDto;

public class UserAppFto extends BaseFto  {

	private static final long serialVersionUID = 1L;
	private RoleUserFto roleUser = new RoleUserFto();
	private String username;

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long fkIdBlobStore;

	private String address;
	private Set<RelUserBlobFto> relUserBlobs = new HashSet<RelUserBlobFto>(0);

	public UserAppFto() {
	}
	
	public UserAppFto(Long id) {
		super.id = id;
	}

	public RoleUserFto getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(RoleUserFto DRoleUser) {
		this.roleUser = DRoleUser;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getFkIdBlobStore() {
		return this.fkIdBlobStore;
	}

	public void setFkIdBlobStore(Long fkIdBlobStore) {
		this.fkIdBlobStore = fkIdBlobStore;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<RelUserBlobFto> getRelUserBlobs() {
		return this.relUserBlobs;
	}

	public void setRelUserBlobs(Set<RelUserBlobFto> DRelUserBlobs) {
		this.relUserBlobs = DRelUserBlobs;
	}
	
	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static UserAppFto createFtoFromDto(UserAppDto dto) {
		if (dto == null) return null;
		
		UserAppFto fto = new UserAppFto();
		BeanUtils.copyProperties(dto, fto);	
		fto.setRoleUser(RoleUserFto.createFtoFromDto(dto.getRoleUser()));
		return fto;
	}

	public static UserAppDto createDtoFromFto(UserAppFto fto) {
		if (fto == null) return null;	
		
		UserAppDto dto = new UserAppDto();
		BeanUtils.copyProperties(fto, dto);
		dto.setRoleUser(RoleUserFto.createDtoFromFto(fto.getRoleUser()));
		return dto;
	}


}
