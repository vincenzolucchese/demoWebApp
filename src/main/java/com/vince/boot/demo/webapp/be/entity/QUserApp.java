package com.vince.boot.demo.webapp.be.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QDUserApp is a Querydsl query type for DUserApp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserApp extends EntityPathBase<UserApp> {

	private static final long serialVersionUID = 346829833L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QUserApp dUserApp = new QUserApp("dUserApp");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final StringPath address = createString("address");

	public final SetPath<RelUserBlob, QRelUserBlob> DRelUserBlobs = this.<RelUserBlob, QRelUserBlob>createSet(
			"DRelUserBlobs", RelUserBlob.class, QRelUserBlob.class, PathInits.DIRECT2);

	public final QRoleUser DRoleUser;

	public final StringPath email = createString("email");

	public final StringPath firstName = createString("firstName");

	public final NumberPath<Long> fkIdBlobStore = createNumber("fkIdBlobStore", Long.class);

	// inherited
	public final NumberPath<Long> id = _super.id;

	public final StringPath lastName = createString("lastName");

	public final StringPath password = createString("password");

	// inherited
	public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

	// inherited
	public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

	// inherited
	public final StringPath userInsert = _super.userInsert;

	public final StringPath username = createString("username");

	// inherited
	public final StringPath userUpdate = _super.userUpdate;

	// inherited
	public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

	public QUserApp(String variable) {
		this(UserApp.class, forVariable(variable), INITS);
	}

	public QUserApp(Path<? extends UserApp> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QUserApp(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QUserApp(PathMetadata metadata, PathInits inits) {
		this(UserApp.class, metadata, inits);
	}

	public QUserApp(Class<? extends UserApp> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DRoleUser = inits.isInitialized("DRoleUser") ? new QRoleUser(forProperty("DRoleUser")) : null;
	}

}
