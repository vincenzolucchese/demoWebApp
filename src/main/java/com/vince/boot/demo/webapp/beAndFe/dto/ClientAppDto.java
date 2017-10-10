package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.ClientApp;

public class ClientAppDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String name;
	private String piva;
	private String address;
	private String zipcode;
	private String notes;
	private String phone;
	private String email;

	private Set<RelClientBlobDto> DRelClientBlobs = new HashSet<RelClientBlobDto>(0);
	private Set<OrderJobDto> DOrderJobs = new HashSet<OrderJobDto>(0);

	public ClientAppDto() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPiva() {
		return this.piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RelClientBlobDto> getDRelClientBlobs() {
		return this.DRelClientBlobs;
	}

	public void setDRelClientBlobs(Set<RelClientBlobDto> DRelClientBlobs) {
		this.DRelClientBlobs = DRelClientBlobs;
	}

	public Set<OrderJobDto> getDOrderJobs() {
		return this.DOrderJobs;
	}

	public void setDOrderJobs(Set<OrderJobDto> DOrderJobs) {
		this.DOrderJobs = DOrderJobs;
	}

	/*
	 * CONVERTER ENTITY <--> DTO
	 */
	@Override
	public BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		ClientAppDto dto = new ClientAppDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		ClientApp entity = new ClientApp();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
