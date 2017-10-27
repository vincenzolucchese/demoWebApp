package com.vince.boot.demo.webapp.beAndFe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import com.vince.boot.demo.webapp.be.entity.OrderJob;
import com.vince.boot.demo.webapp.be.entity.RelOrderBlob;

public class OrderJobDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private ClientAppDto clientApp;

	private String notes;
	private String codeOrder;
	private Date dataScadenza;

	private BigDecimal preAmount;
	private BigDecimal finalAmount;
	private Character flagActive;
	private String address;
	private Set<RelOrderBlobDto> relOrderBlobs = new HashSet<RelOrderBlobDto>(0);
	
	/* field for gmaps */
	private String street_number="";    
	private String locality="";  
	private String administrative_area_level_1="";  
	private String route="";  
	private String postal_code="";  
	private String country="";  
	
	/*******************************************
	 * STATIC ENTITY <--> DTO
	 *******************************************/
	public static OrderJobDto createDtoFromEntity(OrderJob entity) {
		if (entity == null) return null;
		
		OrderJobDto dto = new OrderJobDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setClientApp(ClientAppDto.createDtoFromEntity(entity.getClientApp()));
		
		if(entity.getRelOrderBlobs()!=null) {
			dto.setListBlobs(new ArrayList<BlobStoreDto>());
			for (RelOrderBlob each : entity.getRelOrderBlobs()) {
				dto.getListBlobs().add(BlobStoreDto.createDtoFromEntity(each.getBlobStore()));
			}			
		}
		
		return dto;
	}

	public static OrderJob createEntityFromDto(OrderJobDto dto) {
		if (dto == null) return null;
		
		OrderJob entity = new OrderJob();
		BeanUtils.copyProperties(dto, entity);
		entity.setClientApp(ClientAppDto.createEntityFromDto(dto.getClientApp()));
		return entity;
	}
	
	public OrderJobDto() {
	}
	
	public OrderJobDto(Long id) {
		super.id = id;
	}

	public ClientAppDto getClientApp() {
		return this.clientApp;
	}

	public void setClientApp(ClientAppDto clientApp) {
		this.clientApp = clientApp;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCodeOrder() {
		return this.codeOrder;
	}

	public void setCodeOrder(String codeOrder) {
		this.codeOrder = codeOrder;
	}

	public Date getDataScadenza() {
		return this.dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public BigDecimal getPreAmount() {
		return this.preAmount;
	}

	public void setPreAmount(BigDecimal preAmount) {
		this.preAmount = preAmount;
	}

	public BigDecimal getFinalAmount() {
		return this.finalAmount;
	}

	public void setFinalAmount(BigDecimal finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Character getFlagActive() {
		return this.flagActive;
	}

	public void setFlagActive(Character flagActive) {
		this.flagActive = flagActive;
	}

	public Set<RelOrderBlobDto> getRelOrderBlobs() {
		return this.relOrderBlobs;
	}

	public void setRelOrderBlobs(Set<RelOrderBlobDto> DRelOrderBlobs) {
		this.relOrderBlobs = DRelOrderBlobs;
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
