package com.vince.boot.demo.webapp.beAndFe.dto;

import org.springframework.beans.support.PagedListHolder;

public class MyPagedListHolder<E> extends PagedListHolder<E>{

	private static final long serialVersionUID = 1L;
	private Integer totalPages = new Integer(0);
	private Long totalElements = new Long(0);
	private Boolean hasNext ;
	private Boolean isLast;
	
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Boolean getHasNext() {
		return hasNext;
	}
	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}
	public Boolean getIsLast() {
		return isLast;
	}
	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}
	

}
