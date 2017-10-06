package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDRelClientBlob is a Querydsl query type for DRelClientBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDRelClientBlob extends EntityPathBase<DRelClientBlob> {

    private static final long serialVersionUID = 301696756L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDRelClientBlob dRelClientBlob = new QDRelClientBlob("dRelClientBlob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QDBlobStore DBlobStore;

    public final QDClientApp DClientApp;

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

    public QDRelClientBlob(String variable) {
        this(DRelClientBlob.class, forVariable(variable), INITS);
    }

    public QDRelClientBlob(Path<? extends DRelClientBlob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDRelClientBlob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDRelClientBlob(PathMetadata metadata, PathInits inits) {
        this(DRelClientBlob.class, metadata, inits);
    }

    public QDRelClientBlob(Class<? extends DRelClientBlob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.DBlobStore = inits.isInitialized("DBlobStore") ? new QDBlobStore(forProperty("DBlobStore"), inits.get("DBlobStore")) : null;
        this.DClientApp = inits.isInitialized("DClientApp") ? new QDClientApp(forProperty("DClientApp")) : null;
    }

}

