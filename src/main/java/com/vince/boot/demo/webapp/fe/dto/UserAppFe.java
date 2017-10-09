package com.vince.boot.demo.webapp.fe.dto;

import java.util.HashSet;
import java.util.Set;

public class UserAppFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private RoleUserFe DRoleUser;
	private String username;

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long fkIdBlobStore;

	private String address;
	private Set<RelUserBlobFe> DRelUserBlobs = new HashSet<RelUserBlobFe>(0);

	public UserAppFe() {
	}

	public RoleUserFe getDRoleUser() {
		return this.DRoleUser;
	}

	public void setDRoleUser(RoleUserFe DRoleUser) {
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

	public Set<RelUserBlobFe> getDRelUserBlobs() {
		return this.DRelUserBlobs;
	}

	public void setDRelUserBlobs(Set<RelUserBlobFe> DRelUserBlobs) {
		this.DRelUserBlobs = DRelUserBlobs;
	}

}
