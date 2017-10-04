/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables.records;


import com.vince.boot.demo.webapp.jooq.tables.DRoleUser;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


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
public class DRoleUserRecord extends UpdatableRecordImpl<DRoleUserRecord> implements Record8<String, String, Timestamp, Timestamp, Long, String, String, Date> {

    private static final long serialVersionUID = 696373638;

    /**
     * Setter for <code>demo.d_role_user.user_insert</code>.
     */
    public void setUserInsert(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>demo.d_role_user.user_insert</code>.
     */
    public String getUserInsert() {
        return (String) get(0);
    }

    /**
     * Setter for <code>demo.d_role_user.user_update</code>.
     */
    public void setUserUpdate(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>demo.d_role_user.user_update</code>.
     */
    public String getUserUpdate() {
        return (String) get(1);
    }

    /**
     * Setter for <code>demo.d_role_user.time_insert</code>.
     */
    public void setTimeInsert(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>demo.d_role_user.time_insert</code>.
     */
    public Timestamp getTimeInsert() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>demo.d_role_user.time_update</code>.
     */
    public void setTimeUpdate(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>demo.d_role_user.time_update</code>.
     */
    public Timestamp getTimeUpdate() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>demo.d_role_user.id</code>.
     */
    public void setId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>demo.d_role_user.id</code>.
     */
    public Long getId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>demo.d_role_user.role_code</code>.
     */
    public void setRoleCode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>demo.d_role_user.role_code</code>.
     */
    public String getRoleCode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>demo.d_role_user.role_description</code>.
     */
    public void setRoleDescription(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>demo.d_role_user.role_description</code>.
     */
    public String getRoleDescription() {
        return (String) get(6);
    }

    /**
     * Setter for <code>demo.d_role_user.year_refer</code>.
     */
    public void setYearRefer(Date value) {
        set(7, value);
    }

    /**
     * Getter for <code>demo.d_role_user.year_refer</code>.
     */
    public Date getYearRefer() {
        return (Date) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, Timestamp, Timestamp, Long, String, String, Date> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<String, String, Timestamp, Timestamp, Long, String, String, Date> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return DRoleUser.D_ROLE_USER.USER_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return DRoleUser.D_ROLE_USER.USER_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return DRoleUser.D_ROLE_USER.TIME_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return DRoleUser.D_ROLE_USER.TIME_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return DRoleUser.D_ROLE_USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return DRoleUser.D_ROLE_USER.ROLE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return DRoleUser.D_ROLE_USER.ROLE_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field8() {
        return DRoleUser.D_ROLE_USER.YEAR_REFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
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
    public String value1() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
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
    public DRoleUserRecord value1(String value) {
        setUserInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value2(String value) {
        setUserUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value3(Timestamp value) {
        setTimeInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value4(Timestamp value) {
        setTimeUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value5(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value6(String value) {
        setRoleCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value7(String value) {
        setRoleDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord value8(Date value) {
        setYearRefer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleUserRecord values(String value1, String value2, Timestamp value3, Timestamp value4, Long value5, String value6, String value7, Date value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DRoleUserRecord
     */
    public DRoleUserRecord() {
        super(DRoleUser.D_ROLE_USER);
    }

    /**
     * Create a detached, initialised DRoleUserRecord
     */
    public DRoleUserRecord(String userInsert, String userUpdate, Timestamp timeInsert, Timestamp timeUpdate, Long id, String roleCode, String roleDescription, Date yearRefer) {
        super(DRoleUser.D_ROLE_USER);

        set(0, userInsert);
        set(1, userUpdate);
        set(2, timeInsert);
        set(3, timeUpdate);
        set(4, id);
        set(5, roleCode);
        set(6, roleDescription);
        set(7, yearRefer);
    }
}
