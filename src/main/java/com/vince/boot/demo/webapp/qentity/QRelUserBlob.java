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
import com.vince.boot.demo.webapp.entity.RelUserBlob;


/**
 * QRelUserBlob is a Querydsl query type for RelUserBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelUserBlob extends EntityPathBase<RelUserBlob> {

    private static final long serialVersionUID = 50331562L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRelUserBlob relUserBlob = new QRelUserBlob("relUserBlob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final QBlobStore blobStore;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    public final QUserApp user;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QRelUserBlob(String variable) {
        this(RelUserBlob.class, forVariable(variable), INITS);
    }

    public QRelUserBlob(Path<? extends RelUserBlob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRelUserBlob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRelUserBlob(PathMetadata metadata, PathInits inits) {
        this(RelUserBlob.class, metadata, inits);
    }

    public QRelUserBlob(Class<? extends RelUserBlob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.blobStore = inits.isInitialized("blobStore") ? new QBlobStore(forProperty("blobStore"), inits.get("blobStore")) : null;
        this.user = inits.isInitialized("user") ? new QUserApp(forProperty("user"), inits.get("user")) : null;
    }

}

