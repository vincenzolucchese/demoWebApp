package com.vince.boot.demo.webapp.entity;
// Generated 4-ott-2017 15.34.34 by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DBlobStore generated by hbm2java
 */
@Entity
@Table(name="d_blob_store"
    ,catalog="demo"
)
public class DBlobStore  implements java.io.Serializable {


     private Long id;
     private DTypeDocument DTypeDocument;
     private String userInsert;
     private String userUpdate;
     private Date timeInsert;
     private Date timeUpdate;
     private String filename;
     private char flagActive;
     private byte[] blobData;
     private String description;
     private String contentType;
     private Date yearRefer;
     private Set<DRelOrderBlob> DRelOrderBlobs = new HashSet<DRelOrderBlob>(0);
     private Set<DRelUserBlob> DRelUserBlobs = new HashSet<DRelUserBlob>(0);
     private Set<DRelClientBlob> DRelClientBlobs = new HashSet<DRelClientBlob>(0);

    public DBlobStore() {
    }

	
    public DBlobStore(DTypeDocument DTypeDocument, String userInsert, Date timeInsert, String filename, char flagActive, byte[] blobData, String contentType, Date yearRefer) {
        this.DTypeDocument = DTypeDocument;
        this.userInsert = userInsert;
        this.timeInsert = timeInsert;
        this.filename = filename;
        this.flagActive = flagActive;
        this.blobData = blobData;
        this.contentType = contentType;
        this.yearRefer = yearRefer;
    }
    public DBlobStore(DTypeDocument DTypeDocument, String userInsert, String userUpdate, Date timeInsert, Date timeUpdate, String filename, char flagActive, byte[] blobData, String description, String contentType, Date yearRefer, Set<DRelOrderBlob> DRelOrderBlobs, Set<DRelUserBlob> DRelUserBlobs, Set<DRelClientBlob> DRelClientBlobs) {
       this.DTypeDocument = DTypeDocument;
       this.userInsert = userInsert;
       this.userUpdate = userUpdate;
       this.timeInsert = timeInsert;
       this.timeUpdate = timeUpdate;
       this.filename = filename;
       this.flagActive = flagActive;
       this.blobData = blobData;
       this.description = description;
       this.contentType = contentType;
       this.yearRefer = yearRefer;
       this.DRelOrderBlobs = DRelOrderBlobs;
       this.DRelUserBlobs = DRelUserBlobs;
       this.DRelClientBlobs = DRelClientBlobs;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_id_type", nullable=false)
    public DTypeDocument getDTypeDocument() {
        return this.DTypeDocument;
    }
    
    public void setDTypeDocument(DTypeDocument DTypeDocument) {
        this.DTypeDocument = DTypeDocument;
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
    
    @Column(name="filename", nullable=false, length=200)
    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Column(name="flag_active", nullable=false, length=1)
    public char getFlagActive() {
        return this.flagActive;
    }
    
    public void setFlagActive(char flagActive) {
        this.flagActive = flagActive;
    }
    
    @Column(name="blob_data", nullable=false)
    public byte[] getBlobData() {
        return this.blobData;
    }
    
    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }
    
    @Column(name="description", length=200)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="content_type", nullable=false, length=100)
    public String getContentType() {
        return this.contentType;
    }
    
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="year_refer", nullable=false, length=10)
    public Date getYearRefer() {
        return this.yearRefer;
    }
    
    public void setYearRefer(Date yearRefer) {
        this.yearRefer = yearRefer;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="DBlobStore")
    public Set<DRelOrderBlob> getDRelOrderBlobs() {
        return this.DRelOrderBlobs;
    }
    
    public void setDRelOrderBlobs(Set<DRelOrderBlob> DRelOrderBlobs) {
        this.DRelOrderBlobs = DRelOrderBlobs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="DBlobStore")
    public Set<DRelUserBlob> getDRelUserBlobs() {
        return this.DRelUserBlobs;
    }
    
    public void setDRelUserBlobs(Set<DRelUserBlob> DRelUserBlobs) {
        this.DRelUserBlobs = DRelUserBlobs;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="DBlobStore")
    public Set<DRelClientBlob> getDRelClientBlobs() {
        return this.DRelClientBlobs;
    }
    
    public void setDRelClientBlobs(Set<DRelClientBlob> DRelClientBlobs) {
        this.DRelClientBlobs = DRelClientBlobs;
    }




}


