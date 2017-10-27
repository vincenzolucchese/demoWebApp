package com.vince.boot.demo.webapp.beAndFe.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.vince.boot.demo.webapp.be.entity.ClientApp;
import com.vince.boot.demo.webapp.be.entity.RelClientBlob;

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
