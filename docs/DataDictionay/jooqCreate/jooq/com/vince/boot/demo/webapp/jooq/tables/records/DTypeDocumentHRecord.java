/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables.records;


import com.vince.boot.demo.webapp.jooq.tables.DTypeDocumentH;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class DTypeDocumentHRecord extends TableRecordImpl<DTypeDocumentHRecord> implements Record9<Integer, Integer, Timestamp, Timestamp, Long, String, String, Date, String> {

    private static final long serialVersionUID = -961745073;

    /**
     * Setter for <code>demo.d_type_document_h.user_insert</code>.
     */
    public void setUserInsert(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.user_insert</code>.
     */
    public Integer getUserInsert() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>demo.d_type_document_h.user_update</code>.
     */
    public void setUserUpdate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.user_update</code>.
     */
    public Integer getUserUpdate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>demo.d_type_document_h.time_insert</code>.
     */
    public void setTimeInsert(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.time_insert</code>.
     */
    public Timestamp getTimeInsert() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>demo.d_type_document_h.time_update</code>.
     */
    public void setTimeUpdate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.time_update</code>.
     */
    public Timestamp getTimeUpdate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>demo.d_type_document_h.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.id</code>.
     */
    public Long getId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>demo.d_type_document_h.type_code</code>.
     */
    public void setTypeCode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.type_code</code>.
     */
    public String getTypeCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>demo.d_type_document_h.type_description</code>.
     */
    public void setTypeDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.type_description</code>.
     */
    public String getTypeDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>demo.d_type_document_h.year_refer</code>.
     */
    public void setYearRefer(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.year_refer</code>.
     */
    public Date getYearRefer() {
        return (Date) get(7);
    }

    /**
     * Setter for <code>demo.d_type_document_h.crud_type</code>.
     */
    public void setCrudType(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>demo.d_type_document_h.crud_type</code>.
     */
    public String getCrudType() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, Timestamp, Timestamp, Long, String, String, Date, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, Timestamp, Timestamp, Long, String, String, Date, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.USER_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.USER_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.TIME_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.TIME_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.TYPE_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.YEAR_REFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return DTypeDocumentH.D_TYPE_DOCUMENT_H.CRUD_TYPE;
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
        return getTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getTypeDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component8() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
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
        return getTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getTypeDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value8() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getCrudType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value1(Integer value) {
        setUserInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value2(Integer value) {
        setUserUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value3(Timestamp value) {
        setTimeInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value4(Timestamp value) {
        setTimeUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value6(String value) {
        setTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value7(String value) {
        setTypeDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value8(Date value) {
        setYearRefer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord value9(String value) {
        setCrudType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocumentHRecord values(Integer value1, Integer value2, Timestamp value3, Timestamp value4, Long value5, String value6, String value7, Date value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DTypeDocumentHRecord
     */
    public DTypeDocumentHRecord() {
        super(DTypeDocumentH.D_TYPE_DOCUMENT_H);
    }

    /**
     * Create a detached, initialised DTypeDocumentHRecord
     */
    public DTypeDocumentHRecord(Integer userInsert, Integer userUpdate, Timestamp timeInsert, Timestamp timeUpdate, Long id, String typeCode, String typeDescription, Date yearRefer, String crudType) {
        super(DTypeDocumentH.D_TYPE_DOCUMENT_H);

        set(0, userInsert);
        set(1, userUpdate);
        set(2, timeInsert);
        set(3, timeUpdate);
        set(4, id);
        set(5, typeCode);
        set(6, typeDescription);
        set(7, yearRefer);
        set(8, crudType);
    }
}
