package com.vince.boot.demo.webapp.beAndFe.dto;

import java.io.Serializable;
import java.util.Date;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;


public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String userInsert;
	protected String userUpdate;
	protected Date timeInsert;
	protected Date timeUpdate;
	protected Date yearRefer;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserInsert() {
		return this.userInsert;
	}

	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public Date getTimeInsert() {
		return this.timeInsert;
	}

	public void setTimeInsert(Date timeInsert) {
		this.timeInsert = timeInsert;
	}

	public Date getTimeUpdate() {
		return this.timeUpdate;
	}

	public void setTimeUpdate(Date timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public Date getYearRefer() {
		return yearRefer;
	}

	public void setYearRefer(Date yearRefer) {
		this.yearRefer = yearRefer;
	}
	
	
	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public abstract BaseDto createDtoFromEntity(BaseEntity entity) ;

	public abstract BaseEntity createEntityFromDto(BaseDto dto) ;
	
}
