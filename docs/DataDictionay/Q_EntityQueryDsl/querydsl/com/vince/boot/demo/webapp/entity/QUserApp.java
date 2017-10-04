package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserApp is a Querydsl query type for UserApp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserApp extends EntityPathBase<UserApp> {

    private static final long serialVersionUID = -1789020993L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserApp userApp = new QUserApp("userApp");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> fkIdBlobStore = createNumber("fkIdBlobStore", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lastName = createString("lastName");

    public final StringPath password = createString("password");

    public final SetPath<RelUserBlob, QRelUserBlob> relUserBlobs = this.<RelUserBlob, QRelUserBlob>createSet("relUserBlobs", RelUserBlob.class, QRelUserBlob.class, PathInits.DIRECT2);

    public final QRoleUser roleUser;

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    public final StringPath username = createString("username");

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QUserApp(String variable) {
        this(UserApp.class, forVariable(variable), INITS);
    }

    public QUserApp(Path<? extends UserApp> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserApp(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserApp(PathMetadata metadata, PathInits inits) {
        this(UserApp.class, metadata, inits);
    }

    public QUserApp(Class<? extends UserApp> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.roleUser = inits.isInitialized("roleUser") ? new QRoleUser(forProperty("roleUser"), inits.get("roleUser")) : null;
    }

}

