package com.vince.boot.demo.webapp.beAndFe.dto;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

import org.springframework.beans.support.PagedListHolder;

public class MyPagedListHolder<E> extends PagedListHolder<E>{

	private static final long serialVersionUID = 1L;
	
	private int page = 0; 
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int[] getPagesLinkable() {
		int inizio = 1;
		int fine = DEFAULT_MAX_LINKED_PAGES;
		
		if(page+1 + DEFAULT_MAX_LINKED_PAGES <= totalPages) {
			inizio = page+1 - ( ((page+1) % DEFAULT_MAX_LINKED_PAGES) > 1 ? (page+1) % DEFAULT_MAX_LINKED_PAGES : 0);
			
			inizio = (page - (page % DEFAULT_MAX_LINKED_PAGES));			
			fine = inizio + DEFAULT_MAX_LINKED_PAGES;
		}
		else {
			inizio = (totalPages-DEFAULT_MAX_LINKED_PAGES)>1 ? totalPages-DEFAULT_MAX_LINKED_PAGES : 1 ;
			fine = totalPages;
		}		
		return IntStream.rangeClosed(inizio+1, fine).toArray();
	}
	

}
