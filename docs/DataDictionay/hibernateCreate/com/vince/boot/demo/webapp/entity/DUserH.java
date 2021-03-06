package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DUserH generated by hbm2java
 */
@Entity
@Table(name="d_user_h"
    ,catalog="demo"
)
public class DUserH  implements java.io.Serializable {


     private DUserHId id;

    public DUserH() {
    }

    public DUserH(DUserHId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="username", column=@Column(name="username", length=50) ), 
        @AttributeOverride(name="userInsert", column=@Column(name="user_insert", length=100) ), 
        @AttributeOverride(name="userUpdate", column=@Column(name="user_update", length=100) ), 
        @AttributeOverride(name="timeInsert", column=@Column(name="time_insert", length=19) ), 
        @AttributeOverride(name="timeUpdate", column=@Column(name="time_update", length=19) ), 
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="password", column=@Column(name="password", length=20) ), 
        @AttributeOverride(name="firstName", column=@Column(name="first_name", length=50) ), 
        @AttributeOverride(name="lastName", column=@Column(name="last_name", length=50) ), 
        @AttributeOverride(name="email", column=@Column(name="email", length=100) ), 
        @AttributeOverride(name="fkIdBlobStore", column=@Column(name="fk_id_blob_store") ), 
        @AttributeOverride(name="fkIdRoleUser", column=@Column(name="fk_id_role_user") ), 
        @AttributeOverride(name="yearRefer", column=@Column(name="year_refer", nullable=false, length=10) ), 
        @AttributeOverride(name="crudType", column=@Column(name="crud_type", nullable=false, length=1) ) } )
    public DUserHId getId() {
        return this.id;
    }
    
    public void setId(DUserHId id) {
        this.id = id;
    }




}


