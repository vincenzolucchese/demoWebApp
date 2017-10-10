package com.vince.boot.demo.webapp.beAndFe.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;
import com.vince.boot.demo.webapp.be.entity.OrderJob;

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

	public OrderJobDto() {
	}

	public ClientAppDto getClientApp() {
		return this.clientApp;
	}

	public void setClientApp(ClientAppDto DClientApp) {
		this.clientApp = DClientApp;
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

	/*******************************************
	 * STATIC ENTITY <--> DTO
	 *******************************************/
	public BaseDto createDtoFromEntity(BaseEntity entity) {
		if (entity == null) return null;
		OrderJobDto dto = new OrderJobDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	public BaseEntity createEntityFromDto(BaseDto dto) {
		if (dto == null) return null;
		OrderJob entity = new OrderJob();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
