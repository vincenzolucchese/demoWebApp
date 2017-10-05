package com.vince.boot.demo.webapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class BaseEntity extends AbstractPersistable<Long>  {	
	
	private static final long serialVersionUID = 1L;
	
//	protected Long id;	
	protected String userInsert;
	protected String userUpdate;
	protected Date timeInsert;
	protected Date timeUpdate;
	protected Date yearRefer;

//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "id", unique = true, nullable = false)
//	public Long getId() {
//		return this.id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	@Transient
//    public boolean isNew() {
//        return this.id == null;
//    }
	
	@Column(name = "user_insert", nullable = false)
	public String getUserInsert() {
		return this.userInsert;
	}

	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	@Column(name = "user_update")
	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_insert", nullable = false, length = 19)
	public Date getTimeInsert() {
		return this.timeInsert;
	}

	public void setTimeInsert(Date timeInsert) {
		this.timeInsert = timeInsert;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_update", length = 19)
	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "year_refer", nullable = false, length = 19)
	public Date getYearRefer() {
		return yearRefer;
	}

	public void setYearRefer(Date yearRefer) {
		this.yearRefer = yearRefer;
	}




}
