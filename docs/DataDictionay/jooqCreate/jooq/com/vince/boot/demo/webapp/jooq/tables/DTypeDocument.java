/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables;


import com.vince.boot.demo.webapp.jooq.Demo;
import com.vince.boot.demo.webapp.jooq.Indexes;
import com.vince.boot.demo.webapp.jooq.Keys;
import com.vince.boot.demo.webapp.jooq.tables.records.DTypeDocumentRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class DTypeDocument extends TableImpl<DTypeDocumentRecord> {

    private static final long serialVersionUID = 795627981;

    /**
     * The reference instance of <code>demo.d_type_document</code>
     */
    public static final DTypeDocument D_TYPE_DOCUMENT = new DTypeDocument();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DTypeDocumentRecord> getRecordType() {
        return DTypeDocumentRecord.class;
    }

    /**
     * The column <code>demo.d_type_document.user_insert</code>.
     */
    public final TableField<DTypeDocumentRecord, String> USER_INSERT = createField("user_insert", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_type_document.user_update</code>.
     */
    public final TableField<DTypeDocumentRecord, String> USER_UPDATE = createField("user_update", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>demo.d_type_document.time_insert</code>.
     */
    public final TableField<DTypeDocumentRecord, Timestamp> TIME_INSERT = createField("time_insert", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>demo.d_type_document.time_update</code>.
     */
    public final TableField<DTypeDocumentRecord, Timestamp> TIME_UPDATE = createField("time_update", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>demo.d_type_document.id</code>.
     */
    public final TableField<DTypeDocumentRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>demo.d_type_document.type_code</code>.
     */
    public final TableField<DTypeDocumentRecord, String> TYPE_CODE = createField("type_code", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>demo.d_type_document.type_description</code>.
     */
    public final TableField<DTypeDocumentRecord, String> TYPE_DESCRIPTION = createField("type_description", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_type_document.year_refer</code>.
     */
    public final TableField<DTypeDocumentRecord, Date> YEAR_REFER = createField("year_refer", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>demo.d_type_document</code> table reference
     */
    public DTypeDocument() {
        this(DSL.name("d_type_document"), null);
    }

    /**
     * Create an aliased <code>demo.d_type_document</code> table reference
     */
    public DTypeDocument(String alias) {
        this(DSL.name(alias), D_TYPE_DOCUMENT);
    }

    /**
     * Create an aliased <code>demo.d_type_document</code> table reference
     */
    public DTypeDocument(Name alias) {
        this(alias, D_TYPE_DOCUMENT);
    }

    private DTypeDocument(Name alias, Table<DTypeDocumentRecord> aliased) {
        this(alias, aliased, null);
    }

    private DTypeDocument(Name alias, Table<DTypeDocumentRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.D_TYPE_DOCUMENT_PRIMARY, Indexes.D_TYPE_DOCUMENT_ROLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DTypeDocumentRecord> getPrimaryKey() {
        return Keys.KEY_D_TYPE_DOCUMENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DTypeDocumentRecord>> getKeys() {
        return Arrays.<UniqueKey<DTypeDocumentRecord>>asList(Keys.KEY_D_TYPE_DOCUMENT_PRIMARY, Keys.KEY_D_TYPE_DOCUMENT_ROLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocument as(String alias) {
        return new DTypeDocument(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTypeDocument as(Name alias) {
        return new DTypeDocument(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DTypeDocument rename(String name) {
        return new DTypeDocument(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DTypeDocument rename(Name name) {
        return new DTypeDocument(name, null);
    }
}
