package com.vince.boot.demo.webapp.be.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


/**
 * The Class PageableUtils.
 */
public class PageableUtils {

	/**
	 * Instantiates a new pageable utils.
	 */
	private PageableUtils() { // FIXED
		// Avoid instantiation of the class
	}
	
	/**
	 * Construct page specification.
	 *
	 * @param pageIndex the page index
	 * @param pageLength the page length
	 * @param sortField the sort field
	 * @param sortDirectionAsc the sort direction asc
	 * @return the pageable
	 */
	static public Pageable constructPageSpecification(int pageIndex, int pageLength, String sortField,
			Boolean sortDirectionAsc) {
		Pageable pageSpecification = new PageRequest(pageIndex, pageLength, sortBy(sortField, sortDirectionAsc));
		return pageSpecification;
	}

	/**
	 * Construct page specification.
	 *
	 * @param pageIndex the page index
	 * @param pageSize the page size
	 * @param sortDirectionAsc the sort direction asc
	 * @param columns the columns
	 * @return the pageable
	 */
	static public Pageable constructPageSpecification(int pageIndex, int pageSize, boolean sortDirectionAsc, String... columns) {
		Direction direction=null;
		
		if (sortDirectionAsc){
			direction=Direction.ASC;
		}else{
			direction=Direction.DESC;
		}
		
		Pageable pageable = new PageRequest(pageIndex, pageSize, direction, columns);

		return pageable;
	}
	
	/**
	 * Construct page specification.
	 *
	 * @param pageIndex the page index
	 * @param pageLength the page length
	 * @param sortField the sort field
	 * @return the pageable
	 */
	static public Pageable constructPageSpecification(int pageIndex, int pageLength, String sortField) {
		return constructPageSpecification(pageIndex, pageLength, sortField, true);
	}

	/**
	 * Construct page specification.
	 *
	 * @param pageIndex the page index
	 * @param pageLength the page length
	 * @return the pageable
	 */
	static public Pageable constructPageSpecification(int pageIndex, int pageLength) {
		return constructPageSpecification(pageIndex, pageLength, null, true);
	}

	/**
	 * Returns a Sort object which sorts persons in ascending order by using the
	 * last name.
	 *
	 * @param sortField the sort field
	 * @param sortDirectionAsc the sort direction asc
	 * @return the sort
	 */
	static public Sort sortBy(String sortField, Boolean sortDirectionAsc) {
		if (sortField == null || sortDirectionAsc == null)
			return null;

		return sortDirectionAsc ? new Sort(Sort.Direction.ASC, sortField) : new Sort(Sort.Direction.DESC, sortField);
	}
}
