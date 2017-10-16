package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

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
	
	/* field for gmaps */
	private String street_number="";    
	private String locality="";  
	private String administrative_area_level_1="";  
	private String route="";  
	private String postal_code="";  
	private String country="";  
	
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
		if(!StringUtils.isEmpty(street_number) || !StringUtils.isEmpty(locality)
				|| !StringUtils.isEmpty(administrative_area_level_1) || !StringUtils.isEmpty(route) 
				|| !StringUtils.isEmpty(postal_code) || !StringUtils.isEmpty(country)) {
			this.address = 
					street_number + "§" +  // 1
							locality  + "§" +  // 2
							administrative_area_level_1  + "§" +  // 3
							route  + "§" + // 4
							postal_code  + "§" + // 5
							country  + "§";	// 6			
		}
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

	public String getStreet_number() {
		if(address!=null) {
			street_number = address.split("§")[0];
		}
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getLocality() {
		if(address!=null) {
			locality = address.split("§")[1];
		}
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrative_area_level_1() {
		if(address!=null) {
			administrative_area_level_1 = address.split("§")[2];
		}
		return administrative_area_level_1;
	}

	public void setAdministrative_area_level_1(String administrative_area_level_1) {
		this.administrative_area_level_1 = administrative_area_level_1;
	}

	public String getRoute() {
		if(address!=null) {
			route = address.split("§")[3];
		}
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getPostal_code() {
		if(address!=null) {
			postal_code = address.split("§")[4];
		}
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCountry() {
		if(address!=null) {
			country = address.split("§")[5];
		}
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	



}
