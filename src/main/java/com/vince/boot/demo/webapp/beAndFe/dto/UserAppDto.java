package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.RelUserBlob;
import com.vince.boot.demo.webapp.be.entity.UserApp;

public class UserAppDto extends BaseDto  {

	private static final long serialVersionUID = 1L;
	private RoleUserDto roleUser;
	private String username;

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long fkIdBlobStore;

	private String address;
	private Set<RelUserBlobDto> relUserBlobs = new HashSet<RelUserBlobDto>(0);
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static UserAppDto createDtoFromEntity(UserApp entity) {
		if (entity == null) return null;
		
		UserAppDto dto = new UserAppDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setRoleUser(RoleUserDto.createDtoFromEntity(entity.getRoleUser()));
		
		if(entity.getRelUserBlobs()!=null) {
			dto.setListBlobs(new ArrayList<BlobStoreDto>());
			for (RelUserBlob each : entity.getRelUserBlobs()) {
				dto.getListBlobs().add(BlobStoreDto.createDtoFromEntity(each.getBlobStore()));
			}			
		}
		
		return dto;
	}

	public static UserApp createEntityFromDto(UserAppDto dto) {
		if (dto == null) return null;
		
		UserApp entity = new UserApp();
		BeanUtils.copyProperties(dto, entity);
		entity.setRoleUser(RoleUserDto.createEntityFromDto(dto.getRoleUser()));
		return entity;
	}

	public UserAppDto() {
	}
	
	public UserAppDto(Long id) {
		super.id = id;
	}

	public UserAppDto(String username) {
		this.username = username;
	}

	public RoleUserDto getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(RoleUserDto roleUser) {
		this.roleUser = roleUser;
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

	public Set<RelUserBlobDto> getRelUserBlobs() {
		return this.relUserBlobs;
	}

	public void setRelUserBlobs(Set<RelUserBlobDto> DRelUserBlobs) {
		this.relUserBlobs = DRelUserBlobs;
	}
	



}
