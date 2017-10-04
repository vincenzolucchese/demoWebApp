package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DRelClientBlobHId generated by hbm2java
 */
@Embeddable
public class DRelClientBlobHId  implements java.io.Serializable {


     private Long fkIdClient;
     private Long fkIdBlob;
     private Date timeInsert;
     private Date timeUpdate;
     private String userInsert;
     private String userUpdate;
     private Long id;
     private Date yearRefer;
     private char crudType;

    public DRelClientBlobHId() {
    }

	
    public DRelClientBlobHId(Date yearRefer, char crudType) {
        this.yearRefer = yearRefer;
        this.crudType = crudType;
    }
    public DRelClientBlobHId(Long fkIdClient, Long fkIdBlob, Date timeInsert, Date timeUpdate, String userInsert, String userUpdate, Long id, Date yearRefer, char crudType) {
       this.fkIdClient = fkIdClient;
       this.fkIdBlob = fkIdBlob;
       this.timeInsert = timeInsert;
       this.timeUpdate = timeUpdate;
       this.userInsert = userInsert;
       this.userUpdate = userUpdate;
       this.id = id;
       this.yearRefer = yearRefer;
       this.crudType = crudType;
    }
   

    @Column(name="fk_id_client")
    public Long getFkIdClient() {
        return this.fkIdClient;
    }
    
    public void setFkIdClient(Long fkIdClient) {
        this.fkIdClient = fkIdClient;
    }

    @Column(name="fk_id_blob")
    public Long getFkIdBlob() {
        return this.fkIdBlob;
    }
    
    public void setFkIdBlob(Long fkIdBlob) {
        this.fkIdBlob = fkIdBlob;
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

    @Column(name="id")
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
		 if ( !(other instanceof DRelClientBlobHId) ) return false;
		 DRelClientBlobHId castOther = ( DRelClientBlobHId ) other; 
         
		 return ( (this.getFkIdClient()==castOther.getFkIdClient()) || ( this.getFkIdClient()!=null && castOther.getFkIdClient()!=null && this.getFkIdClient().equals(castOther.getFkIdClient()) ) )
 && ( (this.getFkIdBlob()==castOther.getFkIdBlob()) || ( this.getFkIdBlob()!=null && castOther.getFkIdBlob()!=null && this.getFkIdBlob().equals(castOther.getFkIdBlob()) ) )
 && ( (this.getTimeInsert()==castOther.getTimeInsert()) || ( this.getTimeInsert()!=null && castOther.getTimeInsert()!=null && this.getTimeInsert().equals(castOther.getTimeInsert()) ) )
 && ( (this.getTimeUpdate()==castOther.getTimeUpdate()) || ( this.getTimeUpdate()!=null && castOther.getTimeUpdate()!=null && this.getTimeUpdate().equals(castOther.getTimeUpdate()) ) )
 && ( (this.getUserInsert()==castOther.getUserInsert()) || ( this.getUserInsert()!=null && castOther.getUserInsert()!=null && this.getUserInsert().equals(castOther.getUserInsert()) ) )
 && ( (this.getUserUpdate()==castOther.getUserUpdate()) || ( this.getUserUpdate()!=null && castOther.getUserUpdate()!=null && this.getUserUpdate().equals(castOther.getUserUpdate()) ) )
 && ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getYearRefer()==castOther.getYearRefer()) || ( this.getYearRefer()!=null && castOther.getYearRefer()!=null && this.getYearRefer().equals(castOther.getYearRefer()) ) )
 && (this.getCrudType()==castOther.getCrudType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFkIdClient() == null ? 0 : this.getFkIdClient().hashCode() );
         result = 37 * result + ( getFkIdBlob() == null ? 0 : this.getFkIdBlob().hashCode() );
         result = 37 * result + ( getTimeInsert() == null ? 0 : this.getTimeInsert().hashCode() );
         result = 37 * result + ( getTimeUpdate() == null ? 0 : this.getTimeUpdate().hashCode() );
         result = 37 * result + ( getUserInsert() == null ? 0 : this.getUserInsert().hashCode() );
         result = 37 * result + ( getUserUpdate() == null ? 0 : this.getUserUpdate().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getYearRefer() == null ? 0 : this.getYearRefer().hashCode() );
         result = 37 * result + this.getCrudType();
         return result;
   }   


}


