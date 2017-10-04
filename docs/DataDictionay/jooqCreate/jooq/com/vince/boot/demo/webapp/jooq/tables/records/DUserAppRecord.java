/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables.records;


import com.vince.boot.demo.webapp.jooq.tables.DUserApp;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
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
public class DUserAppRecord extends UpdatableRecordImpl<DUserAppRecord> implements Record14<String, String, String, Timestamp, Timestamp, Long, String, String, String, String, Long, Long, Date, String> {

    private static final long serialVersionUID = -2063477825;

    /**
     * Setter for <code>demo.d_user_app.username</code>.
     */
    public void setUsername(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>demo.d_user_app.username</code>.
     */
    public String getUsername() {
        return (String) get(0);
    }

    /**
     * Setter for <code>demo.d_user_app.user_insert</code>.
     */
    public void setUserInsert(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>demo.d_user_app.user_insert</code>.
     */
    public String getUserInsert() {
        return (String) get(1);
    }

    /**
     * Setter for <code>demo.d_user_app.user_update</code>.
     */
    public void setUserUpdate(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>demo.d_user_app.user_update</code>.
     */
    public String getUserUpdate() {
        return (String) get(2);
    }

    /**
     * Setter for <code>demo.d_user_app.time_insert</code>.
     */
    public void setTimeInsert(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>demo.d_user_app.time_insert</code>.
     */
    public Timestamp getTimeInsert() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>demo.d_user_app.time_update</code>.
     */
    public void setTimeUpdate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>demo.d_user_app.time_update</code>.
     */
    public Timestamp getTimeUpdate() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>demo.d_user_app.id</code>.
     */
    public void setId(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>demo.d_user_app.id</code>.
     */
    public Long getId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>demo.d_user_app.password</code>.
     */
    public void setPassword(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>demo.d_user_app.password</code>.
     */
    public String getPassword() {
        return (String) get(6);
    }

    /**
     * Setter for <code>demo.d_user_app.first_name</code>.
     */
    public void setFirstName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>demo.d_user_app.first_name</code>.
     */
    public String getFirstName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>demo.d_user_app.last_name</code>.
     */
    public void setLastName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>demo.d_user_app.last_name</code>.
     */
    public String getLastName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>demo.d_user_app.email</code>.
     */
    public void setEmail(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>demo.d_user_app.email</code>.
     */
    public String getEmail() {
        return (String) get(9);
    }

    /**
     * Setter for <code>demo.d_user_app.fk_id_blob_store</code>.
     */
    public void setFkIdBlobStore(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>demo.d_user_app.fk_id_blob_store</code>.
     */
    public Long getFkIdBlobStore() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>demo.d_user_app.fk_id_role_user</code>.
     */
    public void setFkIdRoleUser(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>demo.d_user_app.fk_id_role_user</code>.
     */
    public Long getFkIdRoleUser() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>demo.d_user_app.year_refer</code>.
     */
    public void setYearRefer(Date value) {
        set(12, value);
    }

    /**
     * Getter for <code>demo.d_user_app.year_refer</code>.
     */
    public Date getYearRefer() {
        return (Date) get(12);
    }

    /**
     * Setter for <code>demo.d_user_app.address</code>.
     */
    public void setAddress(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>demo.d_user_app.address</code>.
     */
    public String getAddress() {
        return (String) get(13);
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
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, Timestamp, Timestamp, Long, String, String, String, String, Long, Long, Date, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<String, String, String, Timestamp, Timestamp, Long, String, String, String, String, Long, Long, Date, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return DUserApp.D_USER_APP.USERNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return DUserApp.D_USER_APP.USER_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return DUserApp.D_USER_APP.USER_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return DUserApp.D_USER_APP.TIME_INSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return DUserApp.D_USER_APP.TIME_UPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field6() {
        return DUserApp.D_USER_APP.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return DUserApp.D_USER_APP.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return DUserApp.D_USER_APP.FIRST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return DUserApp.D_USER_APP.LAST_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return DUserApp.D_USER_APP.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field11() {
        return DUserApp.D_USER_APP.FK_ID_BLOB_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return DUserApp.D_USER_APP.FK_ID_ROLE_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field13() {
        return DUserApp.D_USER_APP.YEAR_REFER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return DUserApp.D_USER_APP.ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getUserUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getTimeInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getTimeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component6() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component11() {
        return getFkIdBlobStore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getFkIdRoleUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date component13() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUsername();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getUserInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getUserUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getTimeInsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getTimeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value6() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getFirstName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getLastName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value11() {
        return getFkIdBlobStore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getFkIdRoleUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value13() {
        return getYearRefer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value1(String value) {
        setUsername(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value2(String value) {
        setUserInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value3(String value) {
        setUserUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value4(Timestamp value) {
        setTimeInsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value5(Timestamp value) {
        setTimeUpdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value6(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value7(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value8(String value) {
        setFirstName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value9(String value) {
        setLastName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value10(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value11(Long value) {
        setFkIdBlobStore(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value12(Long value) {
        setFkIdRoleUser(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value13(Date value) {
        setYearRefer(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord value14(String value) {
        setAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DUserAppRecord values(String value1, String value2, String value3, Timestamp value4, Timestamp value5, Long value6, String value7, String value8, String value9, String value10, Long value11, Long value12, Date value13, String value14) {
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
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DUserAppRecord
     */
    public DUserAppRecord() {
        super(DUserApp.D_USER_APP);
    }

    /**
     * Create a detached, initialised DUserAppRecord
     */
    public DUserAppRecord(String username, String userInsert, String userUpdate, Timestamp timeInsert, Timestamp timeUpdate, Long id, String password, String firstName, String lastName, String email, Long fkIdBlobStore, Long fkIdRoleUser, Date yearRefer, String address) {
        super(DUserApp.D_USER_APP);

        set(0, username);
        set(1, userInsert);
        set(2, userUpdate);
        set(3, timeInsert);
        set(4, timeUpdate);
        set(5, id);
        set(6, password);
        set(7, firstName);
        set(8, lastName);
        set(9, email);
        set(10, fkIdBlobStore);
        set(11, fkIdRoleUser);
        set(12, yearRefer);
        set(13, address);
    }
}
