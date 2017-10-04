package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRelClientBlob is a Querydsl query type for RelClientBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelClientBlob extends EntityPathBase<RelClientBlob> {

    private static final long serialVersionUID = 1127950122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRelClientBlob relClientBlob = new QRelClientBlob("relClientBlob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBlobStore blobStore;

    public final QClientApp client;

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

    public QRelClientBlob(String variable) {
        this(RelClientBlob.class, forVariable(variable), INITS);
    }

    public QRelClientBlob(Path<? extends RelClientBlob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRelClientBlob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRelClientBlob(PathMetadata metadata, PathInits inits) {
        this(RelClientBlob.class, metadata, inits);
    }

    public QRelClientBlob(Class<? extends RelClientBlob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blobStore = inits.isInitialized("blobStore") ? new QBlobStore(forProperty("blobStore"), inits.get("blobStore")) : null;
        this.client = inits.isInitialized("client") ? new QClientApp(forProperty("client")) : null;
    }

}

