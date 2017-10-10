package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.UserApp;

public class UserAppDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private RoleUserDto DRoleUser;
	private String username;

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long fkIdBlobStore;

	private String address;
	private Set<RelUserBlobDto> DRelUserBlobs = new HashSet<RelUserBlobDto>(0);

	public UserAppDto() {
	}

	public RoleUserDto getDRoleUser() {
		return this.DRoleUser;
	}

	public void setDRoleUser(RoleUserDto DRoleUser) {
		this.DRoleUser = DRoleUser;
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

	public Set<RelUserBlobDto> getDRelUserBlobs() {
		return this.DRelUserBlobs;
	}

	public void setDRelUserBlobs(Set<RelUserBlobDto> DRelUserBlobs) {
		this.DRelUserBlobs = DRelUserBlobs;
	}

	/*
	 * CONVERTER ENTITY <--> DTO
	 */
	public static BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		UserAppDto dto = new UserAppDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public static BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		UserApp entity = new UserApp();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
