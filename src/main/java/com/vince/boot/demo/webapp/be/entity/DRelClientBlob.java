package com.vince.boot.demo.webapp.be.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DRelClientBlob generated by hbm2java
 */
@Entity
@Table(name = "d_rel_client_blob")
public class DRelClientBlob extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private DClientApp DClientApp;
	private DBlobStore DBlobStore;

	public DRelClientBlob() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_client", nullable = false)
	public DClientApp getDClientApp() {
		return this.DClientApp;
	}

	public void setDClientApp(DClientApp DClientApp) {
		this.DClientApp = DClientApp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_blob", nullable = false)
	public DBlobStore getDBlobStore() {
		return this.DBlobStore;
	}

	public void setDBlobStore(DBlobStore DBlobStore) {
		this.DBlobStore = DBlobStore;
	}

}