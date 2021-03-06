package com.vince.boot.demo.webapp.be.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QDRelClientBlob is a Querydsl query type for DRelClientBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelClientBlob extends EntityPathBase<RelClientBlob> {

	private static final long serialVersionUID = 301696756L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QRelClientBlob dRelClientBlob = new QRelClientBlob("dRelClientBlob");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final QBlobStore DBlobStore;

	public final QClientApp DClientApp;

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

	public QRelClientBlob(String variable) {
		this(RelClientBlob.class, forVariable(variable), INITS);
	}

	public QRelClientBlob(Path<? extends RelClientBlob> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QRelClientBlob(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QRelClientBlob(PathMetadata metadata, PathInits inits) {
		this(RelClientBlob.class, metadata, inits);
	}

	public QRelClientBlob(Class<? extends RelClientBlob> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DBlobStore = inits.isInitialized("DBlobStore")
				? new QBlobStore(forProperty("DBlobStore"), inits.get("DBlobStore"))
				: null;
		this.DClientApp = inits.isInitialized("DClientApp") ? new QClientApp(forProperty("DClientApp")) : null;
	}

}
