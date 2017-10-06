package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDOrderJob is a Querydsl query type for DOrderJob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDOrderJob extends EntityPathBase<DOrderJob> {

    private static final long serialVersionUID = -631852484L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDOrderJob dOrderJob = new QDOrderJob("dOrderJob");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath codeOrder = createString("codeOrder");

    public final DateTimePath<java.util.Date> dataScadenza = createDateTime("dataScadenza", java.util.Date.class);

    public final QDClientApp DClientApp;

    public final SetPath<DRelOrderBlob, QDRelOrderBlob> DRelOrderBlobs = this.<DRelOrderBlob, QDRelOrderBlob>createSet("DRelOrderBlobs", DRelOrderBlob.class, QDRelOrderBlob.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> finalAmount = createNumber("finalAmount", java.math.BigDecimal.class);

    public final ComparablePath<Character> flagActive = createComparable("flagActive", Character.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath notes = createString("notes");

    public final NumberPath<java.math.BigDecimal> preAmount = createNumber("preAmount", java.math.BigDecimal.class);

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

    public QDOrderJob(String variable) {
        this(DOrderJob.class, forVariable(variable), INITS);
    }

    public QDOrderJob(Path<? extends DOrderJob> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDOrderJob(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDOrderJob(PathMetadata metadata, PathInits inits) {
        this(DOrderJob.class, metadata, inits);
    }

    public QDOrderJob(Class<? extends DOrderJob> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.DClientApp = inits.isInitialized("DClientApp") ? new QDClientApp(forProperty("DClientApp")) : null;
    }

}

