package com.vince.boot.demo.webapp.fe.dto;

import java.util.HashSet;
import java.util.Set;

public class ClientAppFe extends BaseFe {

	private static final long serialVersionUID = 1L;

	private String name;
	private String piva;
	private String address;
	private String zipcode;
	private String notes;
	private String phone;
	private String email;

	private Set<RelClientBlobFe> DRelClientBlobs = new HashSet<RelClientBlobFe>(0);
	private Set<OrderJobFe> DOrderJobs = new HashSet<OrderJobFe>(0);

	public ClientAppFe() {
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

	public Set<RelClientBlobFe> getDRelClientBlobs() {
		return this.DRelClientBlobs;
	}

	public void setDRelClientBlobs(Set<RelClientBlobFe> DRelClientBlobs) {
		this.DRelClientBlobs = DRelClientBlobs;
	}

	public Set<OrderJobFe> getDOrderJobs() {
		return this.DOrderJobs;
	}

	public void setDOrderJobs(Set<OrderJobFe> DOrderJobs) {
		this.DOrderJobs = DOrderJobs;
	}

}
