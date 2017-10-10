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
 * QDRoleFunction is a Querydsl query type for DRoleFunction
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleFunction extends EntityPathBase<RoleFunction> {

	private static final long serialVersionUID = -1875549029L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QRoleFunction dRoleFunction = new QRoleFunction("dRoleFunction");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final QRoleUser DRoleUser;

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

	public QRoleFunction(String variable) {
		this(RoleFunction.class, forVariable(variable), INITS);
	}

	public QRoleFunction(Path<? extends RoleFunction> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QRoleFunction(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QRoleFunction(PathMetadata metadata, PathInits inits) {
		this(RoleFunction.class, metadata, inits);
	}

	public QRoleFunction(Class<? extends RoleFunction> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DRoleUser = inits.isInitialized("DRoleUser") ? new QRoleUser(forProperty("DRoleUser")) : null;
	}

}
