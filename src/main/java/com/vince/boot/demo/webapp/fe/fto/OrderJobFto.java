package com.vince.boot.demo.webapp.fe.fto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.vince.boot.demo.webapp.beAndFe.dto.BaseDto;
import com.vince.boot.demo.webapp.beAndFe.dto.OrderJobDto;

public class OrderJobFto extends BaseFto {

	private static final long serialVersionUID = 1L;
	private ClientAppFto clientApp;

	private String notes;
	private String codeOrder;
	private Date dataScadenza;

	private BigDecimal preAmount;
	private BigDecimal finalAmount;
	private Character flagActive;
	private String address;
	private Set<RelOrderBlobFto> relOrderBlobs = new HashSet<RelOrderBlobFto>(0);

	public OrderJobFto() {
	}
	
	public OrderJobFto(Long id) {
		super.id = id;
	}

	public ClientAppFto getClientApp() {
		return this.clientApp;
	}

	public void setClientApp(ClientAppFto clientApp) {
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

	public Set<RelOrderBlobFto> getRelOrderBlobs() {
		return this.relOrderBlobs;
	}

	public void setRelOrderBlobs(Set<RelOrderBlobFto> DRelOrderBlobs) {
		this.relOrderBlobs = DRelOrderBlobs;
	}

	/*******************************************
	 * CONVERTER FTO <--> DTO
	 *******************************************/
	public static BaseFto createFtoFromDto(BaseDto dto) {
		if (dto == null) return null;
		
		OrderJobFto fto = new OrderJobFto();
		BeanUtils.copyProperties(dto, fto);		
		return fto;
	}

	public static BaseDto createDtoFromFto(BaseFto fto) {
		if (fto == null) return null;
		
		OrderJobDto dto = new OrderJobDto();
		BeanUtils.copyProperties(fto, dto);
		return dto;
	}

}
