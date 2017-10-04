package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTypeDocument is a Querydsl query type for TypeDocument
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTypeDocument extends EntityPathBase<TypeDocument> {

    private static final long serialVersionUID = 193678764L;

    public static final QTypeDocument typeDocument = new QTypeDocument("typeDocument");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final SetPath<BlobStore, QBlobStore> blobStores = this.<BlobStore, QBlobStore>createSet("blobStores", BlobStore.class, QBlobStore.class, PathInits.DIRECT2);

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

    public QTypeDocument(String variable) {
        super(TypeDocument.class, forVariable(variable));
    }

    public QTypeDocument(Path<? extends TypeDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTypeDocument(PathMetadata metadata) {
        super(TypeDocument.class, metadata);
    }

}

