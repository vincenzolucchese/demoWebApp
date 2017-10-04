/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq.tables;


import com.vince.boot.demo.webapp.jooq.Demo;
import com.vince.boot.demo.webapp.jooq.Indexes;
import com.vince.boot.demo.webapp.jooq.Keys;
import com.vince.boot.demo.webapp.jooq.tables.records.DRoleFunctionRecord;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class DRoleFunction extends TableImpl<DRoleFunctionRecord> {

    private static final long serialVersionUID = 532181082;

    /**
     * The reference instance of <code>demo.d_role_function</code>
     */
    public static final DRoleFunction D_ROLE_FUNCTION = new DRoleFunction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DRoleFunctionRecord> getRecordType() {
        return DRoleFunctionRecord.class;
    }

    /**
     * The column <code>demo.d_role_function.user_insert</code>.
     */
    public final TableField<DRoleFunctionRecord, String> USER_INSERT = createField("user_insert", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>demo.d_role_function.user_update</code>.
     */
    public final TableField<DRoleFunctionRecord, String> USER_UPDATE = createField("user_update", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>demo.d_role_function.time_insert</code>.
     */
    public final TableField<DRoleFunctionRecord, Timestamp> TIME_INSERT = createField("time_insert", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>demo.d_role_function.time_update</code>.
     */
    public final TableField<DRoleFunctionRecord, Timestamp> TIME_UPDATE = createField("time_update", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>demo.d_role_function.id</code>.
     */
    public final TableField<DRoleFunctionRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>demo.d_role_function.year_refer</code>.
     */
    public final TableField<DRoleFunctionRecord, Date> YEAR_REFER = createField("year_refer", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>demo.d_role_function</code> table reference
     */
    public DRoleFunction() {
        this(DSL.name("d_role_function"), null);
    }

    /**
     * Create an aliased <code>demo.d_role_function</code> table reference
     */
    public DRoleFunction(String alias) {
        this(DSL.name(alias), D_ROLE_FUNCTION);
    }

    /**
     * Create an aliased <code>demo.d_role_function</code> table reference
     */
    public DRoleFunction(Name alias) {
        this(alias, D_ROLE_FUNCTION);
    }

    private DRoleFunction(Name alias, Table<DRoleFunctionRecord> aliased) {
        this(alias, aliased, null);
    }

    private DRoleFunction(Name alias, Table<DRoleFunctionRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.D_ROLE_FUNCTION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DRoleFunctionRecord> getPrimaryKey() {
        return Keys.KEY_D_ROLE_FUNCTION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DRoleFunctionRecord>> getKeys() {
        return Arrays.<UniqueKey<DRoleFunctionRecord>>asList(Keys.KEY_D_ROLE_FUNCTION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<DRoleFunctionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DRoleFunctionRecord, ?>>asList(Keys.RELATIONSHIP8);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleFunction as(String alias) {
        return new DRoleFunction(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRoleFunction as(Name alias) {
        return new DRoleFunction(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DRoleFunction rename(String name) {
        return new DRoleFunction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DRoleFunction rename(Name name) {
        return new DRoleFunction(name, null);
    }
}
