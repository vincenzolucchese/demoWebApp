package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;
import com.vince.boot.demo.webapp.be.entity.RelUserBlob;

public class ClientAppDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String name;
	private String piva;
	private String address;
	private String zipcode;
	private String notes;
	private String phone;
	private String email;

	private Set<RelClientBlobDto> relClientBlobs = new HashSet<RelClientBlobDto>(0);
	private Set<OrderJobDto> orderJobs = new HashSet<OrderJobDto>(0);
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public static ClientAppDto createDtoFromEntity(ClientApp entity) {
		if (entity == null) return null;
		
		ClientAppDto dto = new ClientAppDto();
		BeanUtils.copyProperties(entity, dto);
		
		if(entity.getRelClientBlobs()!=null) {
			dto.setListBlobs(new ArrayList<BlobStoreDto>());
			for (RelClientBlob each : entity.getRelClientBlobs()) {
				dto.getListBlobs().add(BlobStoreDto.createDtoFromEntity(each.getBlobStore()));
			}			
		}
		
		return dto;
	}
	
	public static ClientApp createEntityFromDto(ClientAppDto dto) {
		if (dto == null) return null;
		
		ClientApp entity = new ClientApp();
		BeanUtils.copyProperties(dto, entity);
		
//		if(isConvertInside) {
//			if(dtoCast.getOrderJobs()!=null){
//				HashSet<OrderJob> hash = new HashSet<OrderJob>();
//				for (OrderJobDto each : dtoCast.getOrderJobs()) {
//					hash.add((OrderJob) new OrderJobDto().createEntityFromDto(each));
//				}
//				entity.setOrderJobs(hash);
//			}			
//		}
		
		return entity;
	}

	public ClientAppDto() {
	}

	public ClientAppDto(Long id) {
		super.id = id;
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

	public Set<RelClientBlobDto> getRelClientBlobs() {
		return this.relClientBlobs;
	}

	public void setRelClientBlobs(Set<RelClientBlobDto> DRelClientBlobs) {
		this.relClientBlobs = DRelClientBlobs;
	}

	public Set<OrderJobDto> getOrderJobs() {
		return this.orderJobs;
	}

	public void setOrderJobs(Set<OrderJobDto> DOrderJobs) {
		this.orderJobs = DOrderJobs;
	}

}
