package com.vince.boot.demo.webapp.entity;

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
public class QDBlobStore extends EntityPathBase<DBlobStore> {

	private static final long serialVersionUID = -1193072585L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QDBlobStore dBlobStore = new QDBlobStore("dBlobStore");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final ArrayPath<byte[], Byte> blobData = createArray("blobData", byte[].class);

	public final StringPath contentType = createString("contentType");

	public final StringPath description = createString("description");

	public final SetPath<DRelClientBlob, QDRelClientBlob> DRelClientBlobs = this
			.<DRelClientBlob, QDRelClientBlob>createSet("DRelClientBlobs", DRelClientBlob.class, QDRelClientBlob.class,
					PathInits.DIRECT2);

	public final SetPath<DRelOrderBlob, QDRelOrderBlob> DRelOrderBlobs = this.<DRelOrderBlob, QDRelOrderBlob>createSet(
			"DRelOrderBlobs", DRelOrderBlob.class, QDRelOrderBlob.class, PathInits.DIRECT2);

	public final SetPath<DRelUserBlob, QDRelUserBlob> DRelUserBlobs = this.<DRelUserBlob, QDRelUserBlob>createSet(
			"DRelUserBlobs", DRelUserBlob.class, QDRelUserBlob.class, PathInits.DIRECT2);

	public final QDTypeDocument DTypeDocument;

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

	public QDBlobStore(String variable) {
		this(DBlobStore.class, forVariable(variable), INITS);
	}

	public QDBlobStore(Path<? extends DBlobStore> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QDBlobStore(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QDBlobStore(PathMetadata metadata, PathInits inits) {
		this(DBlobStore.class, metadata, inits);
	}

	public QDBlobStore(Class<? extends DBlobStore> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DTypeDocument = inits.isInitialized("DTypeDocument") ? new QDTypeDocument(forProperty("DTypeDocument"))
				: null;
	}

}
