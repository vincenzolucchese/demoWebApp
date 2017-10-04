/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables;


import com.vince.boot.demo.webapp.jooq.Demo;
import com.vince.boot.demo.webapp.jooq.Indexes;
import com.vince.boot.demo.webapp.jooq.Keys;
import com.vince.boot.demo.webapp.jooq.tables.records.DBlobStoreRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class DBlobStore extends TableImpl<DBlobStoreRecord> {

    private static final long serialVersionUID = 1534088983;

    /**
     * The reference instance of <code>demo.d_blob_store</code>
     */
    public static final DBlobStore D_BLOB_STORE = new DBlobStore();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DBlobStoreRecord> getRecordType() {
        return DBlobStoreRecord.class;
    }

    /**
     * The column <code>demo.d_blob_store.user_insert</code>.
     */
    public final TableField<DBlobStoreRecord, String> USER_INSERT = createField("user_insert", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.user_update</code>.
     */
    public final TableField<DBlobStoreRecord, String> USER_UPDATE = createField("user_update", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>demo.d_blob_store.time_insert</code>.
     */
    public final TableField<DBlobStoreRecord, Timestamp> TIME_INSERT = createField("time_insert", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.time_update</code>.
     */
    public final TableField<DBlobStoreRecord, Timestamp> TIME_UPDATE = createField("time_update", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>demo.d_blob_store.id</code>.
     */
    public final TableField<DBlobStoreRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>demo.d_blob_store.filename</code>.
     */
    public final TableField<DBlobStoreRecord, String> FILENAME = createField("filename", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.flag_active</code>.
     */
    public final TableField<DBlobStoreRecord, String> FLAG_ACTIVE = createField("flag_active", org.jooq.impl.SQLDataType.CHAR(1).nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.blob_data</code>.
     */
    public final TableField<DBlobStoreRecord, byte[]> BLOB_DATA = createField("blob_data", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.fk_id_type</code>.
     */
    public final TableField<DBlobStoreRecord, Long> FK_ID_TYPE = createField("fk_id_type", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.description</code>.
     */
    public final TableField<DBlobStoreRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>demo.d_blob_store.content_type</code>.
     */
    public final TableField<DBlobStoreRecord, String> CONTENT_TYPE = createField("content_type", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_blob_store.year_refer</code>.
     */
    public final TableField<DBlobStoreRecord, Date> YEAR_REFER = createField("year_refer", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>demo.d_blob_store</code> table reference
     */
    public DBlobStore() {
        this(DSL.name("d_blob_store"), null);
    }

    /**
     * Create an aliased <code>demo.d_blob_store</code> table reference
     */
    public DBlobStore(String alias) {
        this(DSL.name(alias), D_BLOB_STORE);
    }

    /**
     * Create an aliased <code>demo.d_blob_store</code> table reference
     */
    public DBlobStore(Name alias) {
        this(alias, D_BLOB_STORE);
    }

    private DBlobStore(Name alias, Table<DBlobStoreRecord> aliased) {
        this(alias, aliased, null);
    }

    private DBlobStore(Name alias, Table<DBlobStoreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Demo.DEMO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.D_BLOB_STORE_IX_RELATIONSHIP35, Indexes.D_BLOB_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<DBlobStoreRecord, Long> getIdentity() {
        return Keys.IDENTITY_D_BLOB_STORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DBlobStoreRecord> getPrimaryKey() {
        return Keys.KEY_D_BLOB_STORE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DBlobStoreRecord>> getKeys() {
        return Arrays.<UniqueKey<DBlobStoreRecord>>asList(Keys.KEY_D_BLOB_STORE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DBlobStoreRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DBlobStoreRecord, ?>>asList(Keys.RELATIONSHIP35);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStore as(String alias) {
        return new DBlobStore(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DBlobStore as(Name alias) {
        return new DBlobStore(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DBlobStore rename(String name) {
        return new DBlobStore(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DBlobStore rename(Name name) {
        return new DBlobStore(name, null);
    }
}
