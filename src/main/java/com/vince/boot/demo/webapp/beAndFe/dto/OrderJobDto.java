package com.vince.boot.demo.webapp.beAndFe.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<RelOrderBlobDto> getRelOrderBlobs() {
		return this.relOrderBlobs;
	}

	public void setRelOrderBlobs(Set<RelOrderBlobDto> DRelOrderBlobs) {
		this.relOrderBlobs = DRelOrderBlobs;
	}



}
