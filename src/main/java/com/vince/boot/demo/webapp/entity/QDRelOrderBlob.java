package com.vince.boot.demo.webapp.entity;

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
 * QDRelOrderBlob is a Querydsl query type for DRelOrderBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDRelOrderBlob extends EntityPathBase<DRelOrderBlob> {

	private static final long serialVersionUID = 1244641695L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QDRelOrderBlob dRelOrderBlob = new QDRelOrderBlob("dRelOrderBlob");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final QDBlobStore DBlobStore;

	public final QDOrderJob DOrderJob;

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

	public QDRelOrderBlob(String variable) {
		this(DRelOrderBlob.class, forVariable(variable), INITS);
	}

	public QDRelOrderBlob(Path<? extends DRelOrderBlob> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QDRelOrderBlob(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QDRelOrderBlob(PathMetadata metadata, PathInits inits) {
		this(DRelOrderBlob.class, metadata, inits);
	}

	public QDRelOrderBlob(Class<? extends DRelOrderBlob> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DBlobStore = inits.isInitialized("DBlobStore")
				? new QDBlobStore(forProperty("DBlobStore"), inits.get("DBlobStore"))
				: null;
		this.DOrderJob = inits.isInitialized("DOrderJob")
				? new QDOrderJob(forProperty("DOrderJob"), inits.get("DOrderJob"))
				: null;
	}

}
