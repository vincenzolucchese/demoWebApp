package com.vince.boot.demo.webapp.beAndFe.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vince.boot.demo.webapp.be.entity.BaseEntity;


public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/*******************************************
	 * CONVERTER ENTITY <--> DTO
	 *******************************************/
	public abstract BaseDto createDtoFromEntity(BaseEntity entity) ;
	public abstract BaseEntity createEntityFromDto(BaseDto dto) ;

	protected Boolean isConvertInside = false;
	protected Long id;
	protected String userInsert;
	protected String userUpdate;
	protected Date timeInsert;
	protected Date timeUpdate;
	protected Date yearRefer;
	
	//FIXME: non ok qui
	protected String state;
	protected List<BlobStoreDto> fileDocuments = new ArrayList<BlobStoreDto>();

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

	public Boolean getIsConvertInside() {
		return isConvertInside;
	}

	public void setIsConvertInside(Boolean isConvertInside) {
		this.isConvertInside = isConvertInside;
	}
	public List<BlobStoreDto> getFileDocuments() {
		return fileDocuments;
	}
	public void setFileDocuments(List<BlobStoreDto> fileDocuments) {
		this.fileDocuments = fileDocuments;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
