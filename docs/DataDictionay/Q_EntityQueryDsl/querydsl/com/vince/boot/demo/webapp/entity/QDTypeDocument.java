package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDTypeDocument is a Querydsl query type for DTypeDocument
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDTypeDocument extends EntityPathBase<DTypeDocument> {

    private static final long serialVersionUID = 582667426L;

    public static final QDTypeDocument dTypeDocument = new QDTypeDocument("dTypeDocument");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final SetPath<DBlobStore, QDBlobStore> DBlobStores = this.<DBlobStore, QDBlobStore>createSet("DBlobStores", DBlobStore.class, QDBlobStore.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    public final StringPath typeCode = createString("typeCode");

    public final StringPath typeDescription = createString("typeDescription");

    //inherited
    public final StringPath userInsert = _super.userInsert;

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QDTypeDocument(String variable) {
        super(DTypeDocument.class, forVariable(variable));
    }

    public QDTypeDocument(Path<? extends DTypeDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDTypeDocument(PathMetadata metadata) {
        super(DTypeDocument.class, metadata);
    }

}

