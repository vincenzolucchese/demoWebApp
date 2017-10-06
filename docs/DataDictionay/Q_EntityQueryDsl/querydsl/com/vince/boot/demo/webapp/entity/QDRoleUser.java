package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDRoleUser is a Querydsl query type for DRoleUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDRoleUser extends EntityPathBase<DRoleUser> {

    private static final long serialVersionUID = -2132691442L;

    public static final QDRoleUser dRoleUser = new QDRoleUser("dRoleUser");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final SetPath<DRoleFunction, QDRoleFunction> DRoleFunctions = this.<DRoleFunction, QDRoleFunction>createSet("DRoleFunctions", DRoleFunction.class, QDRoleFunction.class, PathInits.DIRECT2);

    public final SetPath<DUserApp, QDUserApp> DUserApps = this.<DUserApp, QDUserApp>createSet("DUserApps", DUserApp.class, QDUserApp.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath roleCode = createString("roleCode");

    public final StringPath roleDescription = createString("roleDescription");

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QDRoleUser(String variable) {
        super(DRoleUser.class, forVariable(variable));
    }

    public QDRoleUser(Path<? extends DRoleUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDRoleUser(PathMetadata metadata) {
        super(DRoleUser.class, metadata);
    }

}

