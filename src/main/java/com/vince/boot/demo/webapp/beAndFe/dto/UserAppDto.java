package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

public class UserAppDto {

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

	public UserAppDto() {
	}

	public RoleUserDto getRoleUser() {
		return this.roleUser;
	}

	public void setRoleUser(RoleUserDto DRoleUser) {
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

	public Set<RelUserBlobDto> getRelUserBlobs() {
		return this.relUserBlobs;
	}

	public void setRelUserBlobs(Set<RelUserBlobDto> DRelUserBlobs) {
		this.relUserBlobs = DRelUserBlobs;
	}


}
