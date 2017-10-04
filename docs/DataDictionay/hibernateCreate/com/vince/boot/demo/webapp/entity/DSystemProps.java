package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * DSystemProps generated by hbm2java
 */
@Entity
@Table(name="d_system_props"
    ,catalog="demo"
    , uniqueConstraints = @UniqueConstraint(columnNames="key_prop") 
)
public class DSystemProps  implements java.io.Serializable {


     private long id;
     private String userInsert;
     private String userUpdate;
     private Date timeInsert;
     private Date timeUpdate;
     private Date yearRefer;
     private String keyProp;
     private String valueProp;

    public DSystemProps() {
    }

	
    public DSystemProps(long id, String userInsert, Date timeInsert, Date yearRefer, String keyProp, String valueProp) {
        this.id = id;
        this.userInsert = userInsert;
        this.timeInsert = timeInsert;
        this.yearRefer = yearRefer;
        this.keyProp = keyProp;
        this.valueProp = valueProp;
    }
    public DSystemProps(long id, String userInsert, String userUpdate, Date timeInsert, Date timeUpdate, Date yearRefer, String keyProp, String valueProp) {
       this.id = id;
       this.userInsert = userInsert;
       this.userUpdate = userUpdate;
       this.timeInsert = timeInsert;
       this.timeUpdate = timeUpdate;
       this.yearRefer = yearRefer;
       this.keyProp = keyProp;
       this.valueProp = valueProp;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="user_insert", nullable=false, length=100)
    public String getUserInsert() {
        return this.userInsert;
    }
    
    public void setUserInsert(String userInsert) {
        this.userInsert = userInsert;
    }
    
    @Column(name="user_update", length=100)
    public String getUserUpdate() {
        return this.userUpdate;
    }
    
    public void setUserUpdate(String userUpdate) {
        this.userUpdate = userUpdate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_insert", nullable=false, length=19)
    public Date getTimeInsert() {
        return this.timeInsert;
    }
    
    public void setTimeInsert(Date timeInsert) {
        this.timeInsert = timeInsert;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time_update", length=19)
    public Date getTimeUpdate() {
        return this.timeUpdate;
    }
    
    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="year_refer", nullable=false, length=10)
    public Date getYearRefer() {
        return this.yearRefer;
    }
    
    public void setYearRefer(Date yearRefer) {
        this.yearRefer = yearRefer;
    }
    
    @Column(name="key_prop", unique=true, nullable=false, length=20)
    public String getKeyProp() {
        return this.keyProp;
    }
    
    public void setKeyProp(String keyProp) {
        this.keyProp = keyProp;
    }
    
    @Column(name="value_prop", nullable=false, length=200)
    public String getValueProp() {
        return this.valueProp;
    }
    
    public void setValueProp(String valueProp) {
        this.valueProp = valueProp;
    }




}


