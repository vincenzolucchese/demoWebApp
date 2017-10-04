package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderJob is a Querydsl query type for OrderJob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderJob extends EntityPathBase<OrderJob> {

    private static final long serialVersionUID = 1876248646L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderJob orderJob = new QOrderJob("orderJob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    public final QClientApp client;

    public final StringPath codeOrder = createString("codeOrder");

    public final DateTimePath<java.util.Date> dataScadenza = createDateTime("dataScadenza", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> finalAmount = createNumber("finalAmount", java.math.BigDecimal.class);

    public final BooleanPath flagActive = createBoolean("flagActive");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath notes = createString("notes");

    public final NumberPath<java.math.BigDecimal> preAmount = createNumber("preAmount", java.math.BigDecimal.class);

    public final SetPath<RelOrderBlob, QRelOrderBlob> relOrderBlobs = this.<RelOrderBlob, QRelOrderBlob>createSet("relOrderBlobs", RelOrderBlob.class, QRelOrderBlob.class, PathInits.DIRECT2);

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

    public QOrderJob(String variable) {
        this(OrderJob.class, forVariable(variable), INITS);
    }

    public QOrderJob(Path<? extends OrderJob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderJob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderJob(PathMetadata metadata, PathInits inits) {
        this(OrderJob.class, metadata, inits);
    }

    public QOrderJob(Class<? extends OrderJob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.client = inits.isInitialized("client") ? new QClientApp(forProperty("client")) : null;
    }

}

