package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DBlobStoreH generated by hbm2java
 */
@Entity
@Table(name="d_blob_store_h"
    ,catalog="demo"
)
public class DBlobStoreH  implements java.io.Serializable {


     private DBlobStoreHId id;

    public DBlobStoreH() {
    }

    public DBlobStoreH(DBlobStoreHId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="userInsert", column=@Column(name="user_insert") ), 
        @AttributeOverride(name="userUpdate", column=@Column(name="user_update") ), 
        @AttributeOverride(name="timeInsert", column=@Column(name="time_insert", length=19) ), 
        @AttributeOverride(name="timeUpdate", column=@Column(name="time_update", length=19) ), 
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="filename", column=@Column(name="filename", length=200) ), 
        @AttributeOverride(name="flagActive", column=@Column(name="flag_active", length=1) ), 
        @AttributeOverride(name="blobData", column=@Column(name="blob_data") ), 
        @AttributeOverride(name="fkIdType", column=@Column(name="fk_id_type") ), 
        @AttributeOverride(name="description", column=@Column(name="description", length=200) ), 
        @AttributeOverride(name="contentType", column=@Column(name="content_type", length=100) ), 
        @AttributeOverride(name="yearRefer", column=@Column(name="year_refer", nullable=false, length=10) ), 
        @AttributeOverride(name="crudType", column=@Column(name="crud_type", nullable=false, length=1) ) } )
    public DBlobStoreHId getId() {
        return this.id;
    }
    
    public void setId(DBlobStoreHId id) {
        this.id = id;
    }




}


