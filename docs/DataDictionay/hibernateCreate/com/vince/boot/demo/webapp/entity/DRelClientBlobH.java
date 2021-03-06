package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DRelClientBlobH generated by hbm2java
 */
@Entity
@Table(name="d_rel_client_blob_h"
    ,catalog="demo"
)
public class DRelClientBlobH  implements java.io.Serializable {


     private DRelClientBlobHId id;

    public DRelClientBlobH() {
    }

    public DRelClientBlobH(DRelClientBlobHId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="fkIdClient", column=@Column(name="fk_id_client") ), 
        @AttributeOverride(name="fkIdBlob", column=@Column(name="fk_id_blob") ), 
        @AttributeOverride(name="timeInsert", column=@Column(name="time_insert", length=19) ), 
        @AttributeOverride(name="timeUpdate", column=@Column(name="time_update", length=19) ), 
        @AttributeOverride(name="userInsert", column=@Column(name="user_insert", length=100) ), 
        @AttributeOverride(name="userUpdate", column=@Column(name="user_update", length=100) ), 
        @AttributeOverride(name="id", column=@Column(name="id") ), 
        @AttributeOverride(name="yearRefer", column=@Column(name="year_refer", nullable=false, length=10) ), 
        @AttributeOverride(name="crudType", column=@Column(name="crud_type", nullable=false, length=1) ) } )
    public DRelClientBlobHId getId() {
        return this.id;
    }
    
    public void setId(DRelClientBlobHId id) {
        this.id = id;
    }




}


