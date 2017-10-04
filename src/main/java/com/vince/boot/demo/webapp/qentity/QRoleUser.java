package com.vince.boot.demo.webapp.qentity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;
import com.vince.boot.demo.webapp.entity.RoleUser;
import com.vince.boot.demo.webapp.entity.UserApp;


/**
 * QRoleUser is a Querydsl query type for RoleUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleUser extends EntityPathBase<RoleUser> {

    private static final long serialVersionUID = 375409688L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoleUser roleUser = new QRoleUser("roleUser");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath roleCode = createString("roleCode");

    public final StringPath roleDescription = createString("roleDescription");

    public final QRoleFunction roleFunction;

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    public final SetPath<UserApp, QUserApp> users = this.<UserApp, QUserApp>createSet("users", UserApp.class, QUserApp.class, PathInits.DIRECT2);

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QRoleUser(String variable) {
        this(RoleUser.class, forVariable(variable), INITS);
    }

    public QRoleUser(Path<? extends RoleUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoleUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoleUser(PathMetadata metadata, PathInits inits) {
        this(RoleUser.class, metadata, inits);
    }

    public QRoleUser(Class<? extends RoleUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roleFunction = inits.isInitialized("roleFunction") ? new QRoleFunction(forProperty("roleFunction"), inits.get("roleFunction")) : null;
    }

}

