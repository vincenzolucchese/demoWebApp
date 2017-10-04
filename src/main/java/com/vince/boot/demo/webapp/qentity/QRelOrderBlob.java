package com.vince.boot.demo.webapp.qentity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;
import com.vince.boot.demo.webapp.entity.RelOrderBlob;


/**
 * QRelOrderBlob is a Querydsl query type for RelOrderBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelOrderBlob extends EntityPathBase<RelOrderBlob> {

    private static final long serialVersionUID = 855653033L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRelOrderBlob relOrderBlob = new QRelOrderBlob("relOrderBlob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBlobStore blobStore;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QOrderJob order;

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

    public QRelOrderBlob(String variable) {
        this(RelOrderBlob.class, forVariable(variable), INITS);
    }

    public QRelOrderBlob(Path<? extends RelOrderBlob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRelOrderBlob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRelOrderBlob(PathMetadata metadata, PathInits inits) {
        this(RelOrderBlob.class, metadata, inits);
    }

    public QRelOrderBlob(Class<? extends RelOrderBlob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blobStore = inits.isInitialized("blobStore") ? new QBlobStore(forProperty("blobStore"), inits.get("blobStore")) : null;
        this.order = inits.isInitialized("order") ? new QOrderJob(forProperty("order"), inits.get("order")) : null;
    }

}

