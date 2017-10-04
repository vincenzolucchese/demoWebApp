package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClientApp is a Querydsl query type for ClientApp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientApp extends EntityPathBase<ClientApp> {

    private static final long serialVersionUID = 816887423L;

    public static final QClientApp clientApp = new QClientApp("clientApp");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath notes = createString("notes");

    public final SetPath<OrderJob, QOrderJob> orders = this.<OrderJob, QOrderJob>createSet("orders", OrderJob.class, QOrderJob.class, PathInits.DIRECT2);

    public final StringPath phone = createString("phone");

    public final StringPath piva = createString("piva");

    public final SetPath<RelClientBlob, QRelClientBlob> relClientBlobs = this.<RelClientBlob, QRelClientBlob>createSet("relClientBlobs", RelClientBlob.class, QRelClientBlob.class, PathInits.DIRECT2);

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

    public final StringPath zipcode = createString("zipcode");

    public QClientApp(String variable) {
        super(ClientApp.class, forVariable(variable));
    }

    public QClientApp(Path<? extends ClientApp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClientApp(PathMetadata metadata) {
        super(ClientApp.class, metadata);
    }

}

