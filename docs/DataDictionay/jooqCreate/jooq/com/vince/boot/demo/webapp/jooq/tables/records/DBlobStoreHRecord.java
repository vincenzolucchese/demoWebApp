/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables.records;


import com.vince.boot.demo.webapp.jooq.tables.DBlobStoreH;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DBlobStoreHRecord extends TableRecordImpl<DBlobStoreHRecord> implements Record13<Integer, Integer, Timestamp, Timestamp, Long, String, String, byte[], Long, String, String, Date, String> {

    private static final long serialVersionUID = 1214648586;

    /**
     * Setter for <code>demo.d_blob_store_h.user_insert</code>.
     */
    public void setUserInsert(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.user_insert</code>.
     */
    public Integer getUserInsert() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.user_update</code>.
     */
    public void setUserUpdate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.user_update</code>.
     */
    public Integer getUserUpdate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.time_insert</code>.
     */
    public void setTimeInsert(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.time_insert</code>.
     */
    public Timestamp getTimeInsert() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.time_update</code>.
     */
    public void setTimeUpdate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.time_update</code>.
     */
    public Timestamp getTimeUpdate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.id</code>.
     */
    public Long getId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.filename</code>.
     */
    public void setFilename(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.filename</code>.
     */
    public String getFilename() {
        return (String) get(5);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.flag_active</code>.
     */
    public void setFlagActive(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.flag_active</code>.
     */
    public String getFlagActive() {
        return (String) get(6);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.blob_data</code>.
     */
    public void setBlobData(byte... value) {
        set(7, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.blob_data</code>.
     */
    public byte[] getBlobData() {
        return (byte[]) get(7);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.fk_id_type</code>.
     */
    public void setFkIdType(Long value) {
        set(8, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.fk_id_type</code>.
     */
    public Long getFkIdType() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.description</code>.
     */
    public void setDescription(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.description</code>.
     */
    public String getDescription() {
        return (String) get(9);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.content_type</code>.
     */
    public void setContentType(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.content_type</code>.
     */
    public String getContentType() {
        return (String) get(10);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.year_refer</code>.
     */
    public void setYearRefer(Date value) {
        set(11, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.year_refer</code>.
     */
    public Date getYearRefer() {
        return (Date) get(11);
    }

    /**
     * Setter for <code>demo.d_blob_store_h.crud_type</code>.
     */
    public void setCrudType(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>demo.d_blob_store_h.crud_type</code>.
     */
    public String getCrudType() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Integer, Integer, Timestamp, Timestamp, Long, String, String, byte[], Long, String, String, Date, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Integer, Integer, Timestamp, Timestamp, Long, String, String, byte[], Long, String, String, Date, String> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return DBlobStoreH.D_BLOB_STORE_H.USER_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return DBlobStoreH.D_BLOB_STORE_H.USER_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return DBlobStoreH.D_BLOB_STORE_H.TIME_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return DBlobStoreH.D_BLOB_STORE_H.TIME_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return DBlobStoreH.D_BLOB_STORE_H.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return DBlobStoreH.D_BLOB_STORE_H.FILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return DBlobStoreH.D_BLOB_STORE_H.FLAG_ACTIVE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field8() {
        return DBlobStoreH.D_BLOB_STORE_H.BLOB_DATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field9() {
        return DBlobStoreH.D_BLOB_STORE_H.FK_ID_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return DBlobStoreH.D_BLOB_STORE_H.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return DBlobStoreH.D_BLOB_STORE_H.CONTENT_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field12() {
        return DBlobStoreH.D_BLOB_STORE_H.YEAR_REFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return DBlobStoreH.D_BLOB_STORE_H.CRUD_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getUserUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getTimeInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getTimeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getFlagActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component8() {
        return getBlobData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component9() {
        return getFkIdType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getContentType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component12() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getCrudType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getUserUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getTimeInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getTimeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getFlagActive();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value8() {
        return getBlobData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value9() {
        return getFkIdType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getContentType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value12() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getCrudType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value1(Integer value) {
        setUserInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value2(Integer value) {
        setUserUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value3(Timestamp value) {
        setTimeInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value4(Timestamp value) {
        setTimeUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value6(String value) {
        setFilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value7(String value) {
        setFlagActive(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value8(byte... value) {
        setBlobData(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value9(Long value) {
        setFkIdType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value10(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value11(String value) {
        setContentType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value12(Date value) {
        setYearRefer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord value13(String value) {
        setCrudType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStoreHRecord values(Integer value1, Integer value2, Timestamp value3, Timestamp value4, Long value5, String value6, String value7, byte[] value8, Long value9, String value10, String value11, Date value12, String value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DBlobStoreHRecord
     */
    public DBlobStoreHRecord() {
        super(DBlobStoreH.D_BLOB_STORE_H);
    }

    /**
     * Create a detached, initialised DBlobStoreHRecord
     */
    public DBlobStoreHRecord(Integer userInsert, Integer userUpdate, Timestamp timeInsert, Timestamp timeUpdate, Long id, String filename, String flagActive, byte[] blobData, Long fkIdType, String description, String contentType, Date yearRefer, String crudType) {
        super(DBlobStoreH.D_BLOB_STORE_H);

        set(0, userInsert);
        set(1, userUpdate);
        set(2, timeInsert);
        set(3, timeUpdate);
        set(4, id);
        set(5, filename);
        set(6, flagActive);
        set(7, blobData);
        set(8, fkIdType);
        set(9, description);
        set(10, contentType);
        set(11, yearRefer);
        set(12, crudType);
    }
}
