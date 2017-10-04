package com.vince.boot.demo.webapp.qentity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.ArrayPath;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;
import com.vince.boot.demo.webapp.entity.BlobStore;
import com.vince.boot.demo.webapp.entity.RelClientBlob;
import com.vince.boot.demo.webapp.entity.RelOrderBlob;
import com.vince.boot.demo.webapp.entity.RelUserBlob;


/**
 * QBlobStore is a Querydsl query type for BlobStore
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBlobStore extends EntityPathBase<BlobStore> {

    private static final long serialVersionUID = -751348883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBlobStore blobStore = new QBlobStore("blobStore");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ArrayPath<byte[], Byte> blobData = createArray("blobData", byte[].class);

    public final StringPath contentType = createString("contentType");

    public final StringPath description = createString("description");

    public final StringPath filename = createString("filename");

    public final ComparablePath<Character> flagActive = createComparable("flagActive", Character.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<RelClientBlob, QRelClientBlob> relClientBlobs = this.<RelClientBlob, QRelClientBlob>createSet("relClientBlobs", RelClientBlob.class, QRelClientBlob.class, PathInits.DIRECT2);

    public final SetPath<RelOrderBlob, QRelOrderBlob> relOrderBlobs = this.<RelOrderBlob, QRelOrderBlob>createSet("relOrderBlobs", RelOrderBlob.class, QRelOrderBlob.class, PathInits.DIRECT2);

    public final SetPath<RelUserBlob, QRelUserBlob> relUserBlobs = this.<RelUserBlob, QRelUserBlob>createSet("relUserBlobs", RelUserBlob.class, QRelUserBlob.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    public final QTypeDocument typeDocument;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QBlobStore(String variable) {
        this(BlobStore.class, forVariable(variable), INITS);
    }

    public QBlobStore(Path<? extends BlobStore> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBlobStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBlobStore(PathMetadata metadata, PathInits inits) {
        this(BlobStore.class, metadata, inits);
    }

    public QBlobStore(Class<? extends BlobStore> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.typeDocument = inits.isInitialized("typeDocument") ? new QTypeDocument(forProperty("typeDocument")) : null;
    }

}

