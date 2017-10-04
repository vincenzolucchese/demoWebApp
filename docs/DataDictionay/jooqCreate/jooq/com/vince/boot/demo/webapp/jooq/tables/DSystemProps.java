/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables;


import com.vince.boot.demo.webapp.jooq.Demo;
import com.vince.boot.demo.webapp.jooq.Indexes;
import com.vince.boot.demo.webapp.jooq.Keys;
import com.vince.boot.demo.webapp.jooq.tables.records.DSystemPropsRecord;

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
public class DSystemProps extends TableImpl<DSystemPropsRecord> {

    private static final long serialVersionUID = 408106983;

    /**
     * The reference instance of <code>demo.d_system_props</code>
     */
    public static final DSystemProps D_SYSTEM_PROPS = new DSystemProps();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DSystemPropsRecord> getRecordType() {
        return DSystemPropsRecord.class;
    }

    /**
     * The column <code>demo.d_system_props.user_insert</code>.
     */
    public final TableField<DSystemPropsRecord, String> USER_INSERT = createField("user_insert", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_system_props.user_update</code>.
     */
    public final TableField<DSystemPropsRecord, String> USER_UPDATE = createField("user_update", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>demo.d_system_props.time_insert</code>.
     */
    public final TableField<DSystemPropsRecord, Timestamp> TIME_INSERT = createField("time_insert", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>demo.d_system_props.time_update</code>.
     */
    public final TableField<DSystemPropsRecord, Timestamp> TIME_UPDATE = createField("time_update", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>demo.d_system_props.id</code>.
     */
    public final TableField<DSystemPropsRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>demo.d_system_props.year_refer</code>.
     */
    public final TableField<DSystemPropsRecord, Date> YEAR_REFER = createField("year_refer", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>demo.d_system_props.key_prop</code>.
     */
    public final TableField<DSystemPropsRecord, String> KEY_PROP = createField("key_prop", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>demo.d_system_props.value_prop</code>.
     */
    public final TableField<DSystemPropsRecord, String> VALUE_PROP = createField("value_prop", org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * Create a <code>demo.d_system_props</code> table reference
     */
    public DSystemProps() {
        this(DSL.name("d_system_props"), null);
    }

    /**
     * Create an aliased <code>demo.d_system_props</code> table reference
     */
    public DSystemProps(String alias) {
        this(DSL.name(alias), D_SYSTEM_PROPS);
    }

    /**
     * Create an aliased <code>demo.d_system_props</code> table reference
     */
    public DSystemProps(Name alias) {
        this(alias, D_SYSTEM_PROPS);
    }

    private DSystemProps(Name alias, Table<DSystemPropsRecord> aliased) {
        this(alias, aliased, null);
    }

    private DSystemProps(Name alias, Table<DSystemPropsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.D_SYSTEM_PROPS_KEY_PROP, Indexes.D_SYSTEM_PROPS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DSystemPropsRecord> getPrimaryKey() {
        return Keys.KEY_D_SYSTEM_PROPS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DSystemPropsRecord>> getKeys() {
        return Arrays.<UniqueKey<DSystemPropsRecord>>asList(Keys.KEY_D_SYSTEM_PROPS_PRIMARY, Keys.KEY_D_SYSTEM_PROPS_KEY_PROP);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DSystemProps as(String alias) {
        return new DSystemProps(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DSystemProps as(Name alias) {
        return new DSystemProps(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DSystemProps rename(String name) {
        return new DSystemProps(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DSystemProps rename(Name name) {
        return new DSystemProps(name, null);
    }
}
