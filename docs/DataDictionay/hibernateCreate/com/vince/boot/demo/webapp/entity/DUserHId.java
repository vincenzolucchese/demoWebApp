package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DUserHId generated by hbm2java
 */
@Embeddable
public class DUserHId  implements java.io.Serializable {


     private String username;
     private String userInsert;
     private String userUpdate;
     private Date timeInsert;
     private Date timeUpdate;
     private Long id;
     private String password;
     private String firstName;
     private String lastName;
     private String email;
     private Long fkIdBlobStore;
     private Long fkIdRoleUser;
     private Date yearRefer;
     private char crudType;

    public DUserHId() {
    }

	
    public DUserHId(Date yearRefer, char crudType) {
        this.yearRefer = yearRefer;
        this.crudType = crudType;
    }
    public DUserHId(String username, String userInsert, String userUpdate, Date timeInsert, Date timeUpdate, Long id, String password, String firstName, String lastName, String email, Long fkIdBlobStore, Long fkIdRoleUser, Date yearRefer, char crudType) {
       this.username = username;
       this.userInsert = userInsert;
       this.userUpdate = userUpdate;
       this.timeInsert = timeInsert;
       this.timeUpdate = timeUpdate;
       this.id = id;
       this.password = password;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.fkIdBlobStore = fkIdBlobStore;
       this.fkIdRoleUser = fkIdRoleUser;
       this.yearRefer = yearRefer;
       this.crudType = crudType;
    }
   

    @Column(name="username", length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
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

    @Column(name="id")
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="password", length=20)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="first_name", length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name", length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="fk_id_blob_store")
    public Long getFkIdBlobStore() {
        return this.fkIdBlobStore;
    }
    
    public void setFkIdBlobStore(Long fkIdBlobStore) {
        this.fkIdBlobStore = fkIdBlobStore;
    }

    @Column(name="fk_id_role_user")
    public Long getFkIdRoleUser() {
        return this.fkIdRoleUser;
    }
    
    public void setFkIdRoleUser(Long fkIdRoleUser) {
        this.fkIdRoleUser = fkIdRoleUser;
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
		 if ( !(other instanceof DUserHId) ) return false;
		 DUserHId castOther = ( DUserHId ) other; 
         
		 return ( (this.getUsername()==castOther.getUsername()) || ( this.getUsername()!=null && castOther.getUsername()!=null && this.getUsername().equals(castOther.getUsername()) ) )
 && ( (this.getUserInsert()==castOther.getUserInsert()) || ( this.getUserInsert()!=null && castOther.getUserInsert()!=null && this.getUserInsert().equals(castOther.getUserInsert()) ) )
 && ( (this.getUserUpdate()==castOther.getUserUpdate()) || ( this.getUserUpdate()!=null && castOther.getUserUpdate()!=null && this.getUserUpdate().equals(castOther.getUserUpdate()) ) )
 && ( (this.getTimeInsert()==castOther.getTimeInsert()) || ( this.getTimeInsert()!=null && castOther.getTimeInsert()!=null && this.getTimeInsert().equals(castOther.getTimeInsert()) ) )
 && ( (this.getTimeUpdate()==castOther.getTimeUpdate()) || ( this.getTimeUpdate()!=null && castOther.getTimeUpdate()!=null && this.getTimeUpdate().equals(castOther.getTimeUpdate()) ) )
 && ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getPassword()==castOther.getPassword()) || ( this.getPassword()!=null && castOther.getPassword()!=null && this.getPassword().equals(castOther.getPassword()) ) )
 && ( (this.getFirstName()==castOther.getFirstName()) || ( this.getFirstName()!=null && castOther.getFirstName()!=null && this.getFirstName().equals(castOther.getFirstName()) ) )
 && ( (this.getLastName()==castOther.getLastName()) || ( this.getLastName()!=null && castOther.getLastName()!=null && this.getLastName().equals(castOther.getLastName()) ) )
 && ( (this.getEmail()==castOther.getEmail()) || ( this.getEmail()!=null && castOther.getEmail()!=null && this.getEmail().equals(castOther.getEmail()) ) )
 && ( (this.getFkIdBlobStore()==castOther.getFkIdBlobStore()) || ( this.getFkIdBlobStore()!=null && castOther.getFkIdBlobStore()!=null && this.getFkIdBlobStore().equals(castOther.getFkIdBlobStore()) ) )
 && ( (this.getFkIdRoleUser()==castOther.getFkIdRoleUser()) || ( this.getFkIdRoleUser()!=null && castOther.getFkIdRoleUser()!=null && this.getFkIdRoleUser().equals(castOther.getFkIdRoleUser()) ) )
 && ( (this.getYearRefer()==castOther.getYearRefer()) || ( this.getYearRefer()!=null && castOther.getYearRefer()!=null && this.getYearRefer().equals(castOther.getYearRefer()) ) )
 && (this.getCrudType()==castOther.getCrudType());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getUsername() == null ? 0 : this.getUsername().hashCode() );
         result = 37 * result + ( getUserInsert() == null ? 0 : this.getUserInsert().hashCode() );
         result = 37 * result + ( getUserUpdate() == null ? 0 : this.getUserUpdate().hashCode() );
         result = 37 * result + ( getTimeInsert() == null ? 0 : this.getTimeInsert().hashCode() );
         result = 37 * result + ( getTimeUpdate() == null ? 0 : this.getTimeUpdate().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getPassword() == null ? 0 : this.getPassword().hashCode() );
         result = 37 * result + ( getFirstName() == null ? 0 : this.getFirstName().hashCode() );
         result = 37 * result + ( getLastName() == null ? 0 : this.getLastName().hashCode() );
         result = 37 * result + ( getEmail() == null ? 0 : this.getEmail().hashCode() );
         result = 37 * result + ( getFkIdBlobStore() == null ? 0 : this.getFkIdBlobStore().hashCode() );
         result = 37 * result + ( getFkIdRoleUser() == null ? 0 : this.getFkIdRoleUser().hashCode() );
         result = 37 * result + ( getYearRefer() == null ? 0 : this.getYearRefer().hashCode() );
         result = 37 * result + this.getCrudType();
         return result;
   }   


}


