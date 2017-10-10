package com.vince.boot.demo.webapp.be.entity;

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

/**
 * QDBlobStore is a Querydsl query type for DBlobStore
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBlobStore extends EntityPathBase<BlobStore> {

	private static final long serialVersionUID = -1193072585L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QBlobStore dBlobStore = new QBlobStore("dBlobStore");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final ArrayPath<byte[], Byte> blobData = createArray("blobData", byte[].class);

	public final StringPath contentType = createString("contentType");

	public final StringPath description = createString("description");

	public final SetPath<RelClientBlob, QRelClientBlob> DRelClientBlobs = this
			.<RelClientBlob, QRelClientBlob>createSet("DRelClientBlobs", RelClientBlob.class, QRelClientBlob.class,
					PathInits.DIRECT2);

	public final SetPath<RelOrderBlob, QRelOrderBlob> DRelOrderBlobs = this.<RelOrderBlob, QRelOrderBlob>createSet(
			"DRelOrderBlobs", RelOrderBlob.class, QRelOrderBlob.class, PathInits.DIRECT2);

	public final SetPath<RelUserBlob, QRelUserBlob> DRelUserBlobs = this.<RelUserBlob, QRelUserBlob>createSet(
			"DRelUserBlobs", RelUserBlob.class, QRelUserBlob.class, PathInits.DIRECT2);

	public final QTypeDocument DTypeDocument;

	public final StringPath filename = createString("filename");

	public final ComparablePath<Character> flagActive = createComparable("flagActive", Character.class);

	// inherited
	public final NumberPath<Long> id = _super.id;

	// inherited
	public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

	// inherited
	public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

	// inherited
	public final StringPath userInsert = _super.userInsert;

	// inherited
	public final StringPath userUpdate = _super.userUpdate;

	// inherited
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
		this.DTypeDocument = inits.isInitialized("DTypeDocument") ? new QTypeDocument(forProperty("DTypeDocument"))
				: null;
	}

}
