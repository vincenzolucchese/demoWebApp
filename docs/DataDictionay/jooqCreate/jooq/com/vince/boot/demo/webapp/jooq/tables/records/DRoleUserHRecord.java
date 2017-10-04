/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables.records;


import com.vince.boot.demo.webapp.jooq.tables.DRoleUserH;

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
public class DRoleUserHRecord extends TableRecordImpl<DRoleUserHRecord> implements Record9<Integer, Integer, Timestamp, Timestamp, Long, String, String, Date, String> {

    private static final long serialVersionUID = -644001925;

    /**
     * Setter for <code>demo.d_role_user_h.user_insert</code>.
     */
    public void setUserInsert(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.user_insert</code>.
     */
    public Integer getUserInsert() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>demo.d_role_user_h.user_update</code>.
     */
    public void setUserUpdate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.user_update</code>.
     */
    public Integer getUserUpdate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>demo.d_role_user_h.time_insert</code>.
     */
    public void setTimeInsert(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.time_insert</code>.
     */
    public Timestamp getTimeInsert() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>demo.d_role_user_h.time_update</code>.
     */
    public void setTimeUpdate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.time_update</code>.
     */
    public Timestamp getTimeUpdate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>demo.d_role_user_h.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.id</code>.
     */
    public Long getId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>demo.d_role_user_h.role_code</code>.
     */
    public void setRoleCode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.role_code</code>.
     */
    public String getRoleCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>demo.d_role_user_h.role_description</code>.
     */
    public void setRoleDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.role_description</code>.
     */
    public String getRoleDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>demo.d_role_user_h.year_refer</code>.
     */
    public void setYearRefer(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.year_refer</code>.
     */
    public Date getYearRefer() {
        return (Date) get(7);
    }

    /**
     * Setter for <code>demo.d_role_user_h.crud_type</code>.
     */
    public void setCrudType(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>demo.d_role_user_h.crud_type</code>.
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
        return DRoleUserH.D_ROLE_USER_H.USER_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return DRoleUserH.D_ROLE_USER_H.USER_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return DRoleUserH.D_ROLE_USER_H.TIME_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return DRoleUserH.D_ROLE_USER_H.TIME_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return DRoleUserH.D_ROLE_USER_H.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return DRoleUserH.D_ROLE_USER_H.ROLE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return DRoleUserH.D_ROLE_USER_H.ROLE_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return DRoleUserH.D_ROLE_USER_H.YEAR_REFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return DRoleUserH.D_ROLE_USER_H.CRUD_TYPE;
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
        return getRoleCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRoleDescription();
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
        return getRoleCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRoleDescription();
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
    public DRoleUserHRecord value1(Integer value) {
        setUserInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value2(Integer value) {
        setUserUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value3(Timestamp value) {
        setTimeInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value4(Timestamp value) {
        setTimeUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value6(String value) {
        setRoleCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value7(String value) {
        setRoleDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value8(Date value) {
        setYearRefer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord value9(String value) {
        setCrudType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserHRecord values(Integer value1, Integer value2, Timestamp value3, Timestamp value4, Long value5, String value6, String value7, Date value8, String value9) {
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
     * Create a detached DRoleUserHRecord
     */
    public DRoleUserHRecord() {
        super(DRoleUserH.D_ROLE_USER_H);
    }

    /**
     * Create a detached, initialised DRoleUserHRecord
     */
    public DRoleUserHRecord(Integer userInsert, Integer userUpdate, Timestamp timeInsert, Timestamp timeUpdate, Long id, String roleCode, String roleDescription, Date yearRefer, String crudType) {
        super(DRoleUserH.D_ROLE_USER_H);

        set(0, userInsert);
        set(1, userUpdate);
        set(2, timeInsert);
        set(3, timeUpdate);
        set(4, id);
        set(5, roleCode);
        set(6, roleDescription);
        set(7, yearRefer);
        set(8, crudType);
    }
}
