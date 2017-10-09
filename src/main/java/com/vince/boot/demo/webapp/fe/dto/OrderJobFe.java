package com.vince.boot.demo.webapp.fe.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderJobFe extends BaseFe {

	private static final long serialVersionUID = 1L;
	private ClientAppFe DClientApp;

	private String notes;
	private String codeOrder;
	private Date dataScadenza;

	private BigDecimal preAmount;
	private BigDecimal finalAmount;
	private Character flagActive;
	private String address;
	private Set<RelOrderBlobFe> DRelOrderBlobs = new HashSet<RelOrderBlobFe>(0);

	public OrderJobFe() {
	}

	public ClientAppFe getDClientApp() {
		return this.DClientApp;
	}

	public void setDClientApp(ClientAppFe DClientApp) {
		this.DClientApp = DClientApp;
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

	public Set<RelOrderBlobFe> getDRelOrderBlobs() {
		return this.DRelOrderBlobs;
	}

	public void setDRelOrderBlobs(Set<RelOrderBlobFe> DRelOrderBlobs) {
		this.DRelOrderBlobs = DRelOrderBlobs;
	}

}
