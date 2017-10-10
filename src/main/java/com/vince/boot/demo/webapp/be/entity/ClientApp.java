package com.vince.boot.demo.webapp.be.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * DClientApp generated by hbm2java
 */
@Entity
@Table(name = "d_client_app")
public class ClientApp extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String piva;
	private String address;
	private String zipcode;
	private String notes;
	private String phone;
	private String email;

	private Set<RelClientBlob> relClientBlobs = new HashSet<RelClientBlob>(0);
	private Set<OrderJob> orderJobs = new HashSet<OrderJob>(0);

	public ClientApp() {
	}

	public ClientApp(Long id) {
		super.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "piva", nullable = false, length = 16)
	public String getPiva() {
		return this.piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	@Column(name = "address", nullable = false, length = 2000)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", nullable = false, length = 5)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "notes", nullable = false, length = 2000)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "phone", length = 100)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientApp")
	public Set<RelClientBlob> getRelClientBlobs() {
		return this.relClientBlobs;
	}

	public void setRelClientBlobs(Set<RelClientBlob> relClientBlobs) {
		this.relClientBlobs = relClientBlobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientApp")
	public Set<OrderJob> getOrderJobs() {
		return this.orderJobs;
	}

	public void setOrderJobs(Set<OrderJob> orderJobs) {
		this.orderJobs = orderJobs;
	}

}