/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables;


import com.vince.boot.demo.webapp.jooq.Demo;
import com.vince.boot.demo.webapp.jooq.Indexes;
import com.vince.boot.demo.webapp.jooq.Keys;
import com.vince.boot.demo.webapp.jooq.tables.records.DGeoLocalRecord;

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
public class DGeoLocal extends TableImpl<DGeoLocalRecord> {

    private static final long serialVersionUID = 2135068541;

    /**
     * The reference instance of <code>demo.d_geo_local</code>
     */
    public static final DGeoLocal D_GEO_LOCAL = new DGeoLocal();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DGeoLocalRecord> getRecordType() {
        return DGeoLocalRecord.class;
    }

    /**
     * The column <code>demo.d_geo_local.user_insert</code>.
     */
    public final TableField<DGeoLocalRecord, String> USER_INSERT = createField("user_insert", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_geo_local.user_update</code>.
     */
    public final TableField<DGeoLocalRecord, String> USER_UPDATE = createField("user_update", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>demo.d_geo_local.time_insert</code>.
     */
    public final TableField<DGeoLocalRecord, Timestamp> TIME_INSERT = createField("time_insert", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>demo.d_geo_local.time_update</code>.
     */
    public final TableField<DGeoLocalRecord, Timestamp> TIME_UPDATE = createField("time_update", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>demo.d_geo_local.id</code>.
     */
    public final TableField<DGeoLocalRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>demo.d_geo_local.year_refer</code>.
     */
    public final TableField<DGeoLocalRecord, Date> YEAR_REFER = createField("year_refer", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>demo.d_geo_local</code> table reference
     */
    public DGeoLocal() {
        this(DSL.name("d_geo_local"), null);
    }

    /**
     * Create an aliased <code>demo.d_geo_local</code> table reference
     */
    public DGeoLocal(String alias) {
        this(DSL.name(alias), D_GEO_LOCAL);
    }

    /**
     * Create an aliased <code>demo.d_geo_local</code> table reference
     */
    public DGeoLocal(Name alias) {
        this(alias, D_GEO_LOCAL);
    }

    private DGeoLocal(Name alias, Table<DGeoLocalRecord> aliased) {
        this(alias, aliased, null);
    }

    private DGeoLocal(Name alias, Table<DGeoLocalRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.D_GEO_LOCAL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DGeoLocalRecord> getPrimaryKey() {
        return Keys.KEY_D_GEO_LOCAL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DGeoLocalRecord>> getKeys() {
        return Arrays.<UniqueKey<DGeoLocalRecord>>asList(Keys.KEY_D_GEO_LOCAL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DGeoLocal as(String alias) {
        return new DGeoLocal(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DGeoLocal as(Name alias) {
        return new DGeoLocal(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DGeoLocal rename(String name) {
        return new DGeoLocal(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DGeoLocal rename(Name name) {
        return new DGeoLocal(name, null);
    }
}
