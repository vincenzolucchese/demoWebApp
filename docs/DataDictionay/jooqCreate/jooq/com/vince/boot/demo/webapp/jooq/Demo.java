/*
 * This file is generated by jOOQ.
*/
package com.vince.boot.demo.webapp.jooq;


import com.vince.boot.demo.webapp.jooq.tables.DBlobStore;
import com.vince.boot.demo.webapp.jooq.tables.DBlobStoreH;
import com.vince.boot.demo.webapp.jooq.tables.DClientApp;
import com.vince.boot.demo.webapp.jooq.tables.DClientH;
import com.vince.boot.demo.webapp.jooq.tables.DGeoLocal;
import com.vince.boot.demo.webapp.jooq.tables.DGeoLocalH;
import com.vince.boot.demo.webapp.jooq.tables.DOrderJob;
import com.vince.boot.demo.webapp.jooq.tables.DOrderJobH;
import com.vince.boot.demo.webapp.jooq.tables.DRelClientBlob;
import com.vince.boot.demo.webapp.jooq.tables.DRelClientBlobH;
import com.vince.boot.demo.webapp.jooq.tables.DRelOrderBlob;
import com.vince.boot.demo.webapp.jooq.tables.DRelOrderBlobH;
import com.vince.boot.demo.webapp.jooq.tables.DRelUserBlob;
import com.vince.boot.demo.webapp.jooq.tables.DRelUserBlobH;
import com.vince.boot.demo.webapp.jooq.tables.DRoleFunction;
import com.vince.boot.demo.webapp.jooq.tables.DRoleFunctionH;
import com.vince.boot.demo.webapp.jooq.tables.DRoleUser;
import com.vince.boot.demo.webapp.jooq.tables.DRoleUserH;
import com.vince.boot.demo.webapp.jooq.tables.DSystemProps;
import com.vince.boot.demo.webapp.jooq.tables.DSystemPropsH;
import com.vince.boot.demo.webapp.jooq.tables.DTypeDocument;
import com.vince.boot.demo.webapp.jooq.tables.DTypeDocumentH;
import com.vince.boot.demo.webapp.jooq.tables.DUserApp;
import com.vince.boot.demo.webapp.jooq.tables.DUserH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Demo extends SchemaImpl {

    private static final long serialVersionUID = 1817344235;

    /**
     * The reference instance of <code>demo</code>
     */
    public static final Demo DEMO = new Demo();

    /**
     * The table <code>demo.d_blob_store</code>.
     */
    public final DBlobStore D_BLOB_STORE = com.vince.boot.demo.webapp.jooq.tables.DBlobStore.D_BLOB_STORE;

    /**
     * The table <code>demo.d_blob_store_h</code>.
     */
    public final DBlobStoreH D_BLOB_STORE_H = com.vince.boot.demo.webapp.jooq.tables.DBlobStoreH.D_BLOB_STORE_H;

    /**
     * The table <code>demo.d_client_app</code>.
     */
    public final DClientApp D_CLIENT_APP = com.vince.boot.demo.webapp.jooq.tables.DClientApp.D_CLIENT_APP;

    /**
     * The table <code>demo.d_client_h</code>.
     */
    public final DClientH D_CLIENT_H = com.vince.boot.demo.webapp.jooq.tables.DClientH.D_CLIENT_H;

    /**
     * The table <code>demo.d_geo_local</code>.
     */
    public final DGeoLocal D_GEO_LOCAL = com.vince.boot.demo.webapp.jooq.tables.DGeoLocal.D_GEO_LOCAL;

    /**
     * The table <code>demo.d_geo_local_h</code>.
     */
    public final DGeoLocalH D_GEO_LOCAL_H = com.vince.boot.demo.webapp.jooq.tables.DGeoLocalH.D_GEO_LOCAL_H;

    /**
     * The table <code>demo.d_order_job</code>.
     */
    public final DOrderJob D_ORDER_JOB = com.vince.boot.demo.webapp.jooq.tables.DOrderJob.D_ORDER_JOB;

    /**
     * The table <code>demo.d_order_job_h</code>.
     */
    public final DOrderJobH D_ORDER_JOB_H = com.vince.boot.demo.webapp.jooq.tables.DOrderJobH.D_ORDER_JOB_H;

    /**
     * The table <code>demo.d_rel_client_blob</code>.
     */
    public final DRelClientBlob D_REL_CLIENT_BLOB = com.vince.boot.demo.webapp.jooq.tables.DRelClientBlob.D_REL_CLIENT_BLOB;

    /**
     * The table <code>demo.d_rel_client_blob_h</code>.
     */
    public final DRelClientBlobH D_REL_CLIENT_BLOB_H = com.vince.boot.demo.webapp.jooq.tables.DRelClientBlobH.D_REL_CLIENT_BLOB_H;

    /**
     * The table <code>demo.d_rel_order_blob</code>.
     */
    public final DRelOrderBlob D_REL_ORDER_BLOB = com.vince.boot.demo.webapp.jooq.tables.DRelOrderBlob.D_REL_ORDER_BLOB;

    /**
     * The table <code>demo.d_rel_order_blob_h</code>.
     */
    public final DRelOrderBlobH D_REL_ORDER_BLOB_H = com.vince.boot.demo.webapp.jooq.tables.DRelOrderBlobH.D_REL_ORDER_BLOB_H;

    /**
     * The table <code>demo.d_rel_user_blob</code>.
     */
    public final DRelUserBlob D_REL_USER_BLOB = com.vince.boot.demo.webapp.jooq.tables.DRelUserBlob.D_REL_USER_BLOB;

    /**
     * The table <code>demo.d_rel_user_blob_h</code>.
     */
    public final DRelUserBlobH D_REL_USER_BLOB_H = com.vince.boot.demo.webapp.jooq.tables.DRelUserBlobH.D_REL_USER_BLOB_H;

    /**
     * The table <code>demo.d_role_function</code>.
     */
    public final DRoleFunction D_ROLE_FUNCTION = com.vince.boot.demo.webapp.jooq.tables.DRoleFunction.D_ROLE_FUNCTION;

    /**
     * The table <code>demo.d_role_function_h</code>.
     */
    public final DRoleFunctionH D_ROLE_FUNCTION_H = com.vince.boot.demo.webapp.jooq.tables.DRoleFunctionH.D_ROLE_FUNCTION_H;

    /**
     * The table <code>demo.d_role_user</code>.
     */
    public final DRoleUser D_ROLE_USER = com.vince.boot.demo.webapp.jooq.tables.DRoleUser.D_ROLE_USER;

    /**
     * The table <code>demo.d_role_user_h</code>.
     */
    public final DRoleUserH D_ROLE_USER_H = com.vince.boot.demo.webapp.jooq.tables.DRoleUserH.D_ROLE_USER_H;

    /**
     * The table <code>demo.d_system_props</code>.
     */
    public final DSystemProps D_SYSTEM_PROPS = com.vince.boot.demo.webapp.jooq.tables.DSystemProps.D_SYSTEM_PROPS;

    /**
     * The table <code>demo.d_system_props_h</code>.
     */
    public final DSystemPropsH D_SYSTEM_PROPS_H = com.vince.boot.demo.webapp.jooq.tables.DSystemPropsH.D_SYSTEM_PROPS_H;

    /**
     * The table <code>demo.d_type_document</code>.
     */
    public final DTypeDocument D_TYPE_DOCUMENT = com.vince.boot.demo.webapp.jooq.tables.DTypeDocument.D_TYPE_DOCUMENT;

    /**
     * The table <code>demo.d_type_document_h</code>.
     */
    public final DTypeDocumentH D_TYPE_DOCUMENT_H = com.vince.boot.demo.webapp.jooq.tables.DTypeDocumentH.D_TYPE_DOCUMENT_H;

    /**
     * The table <code>demo.d_user_app</code>.
     */
    public final DUserApp D_USER_APP = com.vince.boot.demo.webapp.jooq.tables.DUserApp.D_USER_APP;

    /**
     * The table <code>demo.d_user_h</code>.
     */
    public final DUserH D_USER_H = com.vince.boot.demo.webapp.jooq.tables.DUserH.D_USER_H;

    /**
     * No further instances allowed
     */
    private Demo() {
        super("demo", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            DBlobStore.D_BLOB_STORE,
            DBlobStoreH.D_BLOB_STORE_H,
            DClientApp.D_CLIENT_APP,
            DClientH.D_CLIENT_H,
            DGeoLocal.D_GEO_LOCAL,
            DGeoLocalH.D_GEO_LOCAL_H,
            DOrderJob.D_ORDER_JOB,
            DOrderJobH.D_ORDER_JOB_H,
            DRelClientBlob.D_REL_CLIENT_BLOB,
            DRelClientBlobH.D_REL_CLIENT_BLOB_H,
            DRelOrderBlob.D_REL_ORDER_BLOB,
            DRelOrderBlobH.D_REL_ORDER_BLOB_H,
            DRelUserBlob.D_REL_USER_BLOB,
            DRelUserBlobH.D_REL_USER_BLOB_H,
            DRoleFunction.D_ROLE_FUNCTION,
            DRoleFunctionH.D_ROLE_FUNCTION_H,
            DRoleUser.D_ROLE_USER,
            DRoleUserH.D_ROLE_USER_H,
            DSystemProps.D_SYSTEM_PROPS,
            DSystemPropsH.D_SYSTEM_PROPS_H,
            DTypeDocument.D_TYPE_DOCUMENT,
            DTypeDocumentH.D_TYPE_DOCUMENT_H,
            DUserApp.D_USER_APP,
            DUserH.D_USER_H);
    }
}
