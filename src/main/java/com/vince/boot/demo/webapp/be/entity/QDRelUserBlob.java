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
public class QDRelUserBlob extends EntityPathBase<DRelUserBlob> {

	private static final long serialVersionUID = 755616244L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QDRelUserBlob dRelUserBlob = new QDRelUserBlob("dRelUserBlob");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final QDBlobStore DBlobStore;

	public final QDUserApp DUserApp;

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

	public QDRelUserBlob(String variable) {
		this(DRelUserBlob.class, forVariable(variable), INITS);
	}

	public QDRelUserBlob(Path<? extends DRelUserBlob> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QDRelUserBlob(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QDRelUserBlob(PathMetadata metadata, PathInits inits) {
		this(DRelUserBlob.class, metadata, inits);
	}

	public QDRelUserBlob(Class<? extends DRelUserBlob> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DBlobStore = inits.isInitialized("DBlobStore")
				? new QDBlobStore(forProperty("DBlobStore"), inits.get("DBlobStore"))
				: null;
		this.DUserApp = inits.isInitialized("DUserApp") ? new QDUserApp(forProperty("DUserApp"), inits.get("DUserApp"))
				: null;
	}

}
