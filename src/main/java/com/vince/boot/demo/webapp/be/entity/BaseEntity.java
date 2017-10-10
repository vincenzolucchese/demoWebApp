package com.vince.boot.demo.webapp.be.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;
	protected String userInsert;
	protected String userUpdate;
	protected Date timeInsert;
	protected Date timeUpdate;
	protected Date yearRefer;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	/**
	 * Must be {@link Transient} in order to ensure that no JPA provider complains
	 * because of a missing setter.
	 * 
	 * @see org.springframework.data.domain.Persistable#isNew()
	 */
	@Transient // DATAJPA-622
	public boolean isNew() {
		return null == getId();
	}

	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
