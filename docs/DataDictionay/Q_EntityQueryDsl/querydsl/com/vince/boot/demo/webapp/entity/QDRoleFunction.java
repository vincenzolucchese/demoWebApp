package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDRoleFunction is a Querydsl query type for DRoleFunction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDRoleFunction extends EntityPathBase<DRoleFunction> {

    private static final long serialVersionUID = -1875549029L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDRoleFunction dRoleFunction = new QDRoleFunction("dRoleFunction");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QDRoleUser DRoleUser;

    //inherited
    public final NumberPath<Long> id = _super.id;

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

    public QDRoleFunction(String variable) {
        this(DRoleFunction.class, forVariable(variable), INITS);
    }

    public QDRoleFunction(Path<? extends DRoleFunction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDRoleFunction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDRoleFunction(PathMetadata metadata, PathInits inits) {
        this(DRoleFunction.class, metadata, inits);
    }

    public QDRoleFunction(Class<? extends DRoleFunction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.DRoleUser = inits.isInitialized("DRoleUser") ? new QDRoleUser(forProperty("DRoleUser")) : null;
    }

}

