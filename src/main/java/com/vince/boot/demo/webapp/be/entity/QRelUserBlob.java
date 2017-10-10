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
 * QDRelUserBlob is a Querydsl query type for DRelUserBlob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRelUserBlob extends EntityPathBase<RelUserBlob> {

	private static final long serialVersionUID = 755616244L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QRelUserBlob dRelUserBlob = new QRelUserBlob("dRelUserBlob");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final QBlobStore DBlobStore;

	public final QUserApp DUserApp;

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

	public QRelUserBlob(String variable) {
		this(RelUserBlob.class, forVariable(variable), INITS);
	}

	public QRelUserBlob(Path<? extends RelUserBlob> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QRelUserBlob(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QRelUserBlob(PathMetadata metadata, PathInits inits) {
		this(RelUserBlob.class, metadata, inits);
	}

	public QRelUserBlob(Class<? extends RelUserBlob> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DBlobStore = inits.isInitialized("DBlobStore")
				? new QBlobStore(forProperty("DBlobStore"), inits.get("DBlobStore"))
				: null;
		this.DUserApp = inits.isInitialized("DUserApp") ? new QUserApp(forProperty("DUserApp"), inits.get("DUserApp"))
				: null;
	}

}
