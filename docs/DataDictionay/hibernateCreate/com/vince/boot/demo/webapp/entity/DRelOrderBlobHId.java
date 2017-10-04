package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DRelOrderBlobHId generated by hbm2java
 */
@Embeddable
public class DRelOrderBlobHId  implements java.io.Serializable {


     private Long fkIdOrder;
     private Long fkIdBlob;
     private Long id;
     private String userInsert;
     private String userUpdate;
     private Date timeInsert;
     private Date timeUpdate;
     private Date yearRefer;
     private char crudType;

    public DRelOrderBlobHId() {
    }

	
    public DRelOrderBlobHId(Date yearRefer, char crudType) {
        this.yearRefer = yearRefer;
        this.crudType = crudType;
    }
    public DRelOrderBlobHId(Long fkIdOrder, Long fkIdBlob, Long id, String userInsert, String userUpdate, Date timeInsert, Date timeUpdate, Date yearRefer, char crudType) {
       this.fkIdOrder = fkIdOrder;
       this.fkIdBlob = fkIdBlob;
       this.id = id;
       this.userInsert = userInsert;
       this.userUpdate = userUpdate;
       this.timeInsert = timeInsert;
       this.timeUpdate = timeUpdate;
       this.yearRefer = yearRefer;
       this.crudType = crudType;
    }
   

    @Column(name="fk_id_order")
    public Long getFkIdOrder() {
        return this.fkIdOrder;
    }
    
    public void setFkIdOrder(Long fkIdOrder) {
        this.fkIdOrder = fkIdOrder;
    }

    @Column(name="fk_id_blob")
    public Long getFkIdBlob() {
        return this.fkIdBlob;
    }
    
    public void setFkIdBlob(Long fkIdBlob) {
        this.fkIdBlob = fkIdBlob;
    }

    @Column(name="id")
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="user_insert", length=100)
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

    @Column(name="time_insert", length=19)
    public Date getTimeInsert() {
        return this.timeInsert;
    }
    
    public void setTimeInsert(Date timeInsert) {
        this.timeInsert = timeInsert;
    }

    @Column(name="time_update", length=19)
    public Date getTimeUpdate() {
        return this.timeUpdate;
    }
    
    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    @Column(name="year_refer", nullable=false, length=10)
    public Date getYearRefer() {
        return this.yearRefer;
    }
    
    public void setYearRefer(Date yearRefer) {
        this.yearRefer = yearRefer;
    }

    @Column(name="crud_type", nullable=false, length=1)
    public char getCrudType() {
        return this.crudType;
    }
    
    public void setCrudType(char crudType) {
        this.crudType = crudType;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DRelOrderBlobHId) ) return false;
		 DRelOrderBlobHId castOther = ( DRelOrderBlobHId ) other; 
         
		 return ( (this.getFkIdOrder()==castOther.getFkIdOrder()) || ( this.getFkIdOrder()!=null && castOther.getFkIdOrder()!=null && this.getFkIdOrder().equals(castOther.getFkIdOrder()) ) )
 && ( (this.getFkIdBlob()==castOther.getFkIdBlob()) || ( this.getFkIdBlob()!=null && castOther.getFkIdBlob()!=null && this.getFkIdBlob().equals(castOther.getFkIdBlob()) ) )
 && ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getUserInsert()==castOther.getUserInsert()) || ( this.getUserInsert()!=null && castOther.getUserInsert()!=null && this.getUserInsert().equals(castOther.getUserInsert()) ) )
 && ( (this.getUserUpdate()==castOther.getUserUpdate()) || ( this.getUserUpdate()!=null && castOther.getUserUpdate()!=null && this.getUserUpdate().equals(castOther.getUserUpdate()) ) )
 && ( (this.getTimeInsert()==castOther.getTimeInsert()) || ( this.getTimeInsert()!=null && castOther.getTimeInsert()!=null && this.getTimeInsert().equals(castOther.getTimeInsert()) ) )
 && ( (this.getTimeUpdate()==castOther.getTimeUpdate()) || ( this.getTimeUpdate()!=null && castOther.getTimeUpdate()!=null && this.getTimeUpdate().equals(castOther.getTimeUpdate()) ) )
 && ( (this.getYearRefer()==castOther.getYearRefer()) || ( this.getYearRefer()!=null && castOther.getYearRefer()!=null && this.getYearRefer().equals(castOther.getYearRefer()) ) )
 && (this.getCrudType()==castOther.getCrudType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFkIdOrder() == null ? 0 : this.getFkIdOrder().hashCode() );
         result = 37 * result + ( getFkIdBlob() == null ? 0 : this.getFkIdBlob().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getUserInsert() == null ? 0 : this.getUserInsert().hashCode() );
         result = 37 * result + ( getUserUpdate() == null ? 0 : this.getUserUpdate().hashCode() );
         result = 37 * result + ( getTimeInsert() == null ? 0 : this.getTimeInsert().hashCode() );
         result = 37 * result + ( getTimeUpdate() == null ? 0 : this.getTimeUpdate().hashCode() );
         result = 37 * result + ( getYearRefer() == null ? 0 : this.getYearRefer().hashCode() );
         result = 37 * result + this.getCrudType();
         return result;
   }   


}


