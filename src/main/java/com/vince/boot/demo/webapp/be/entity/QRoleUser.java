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
 * QDRoleUser is a Querydsl query type for DRoleUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoleUser extends EntityPathBase<RoleUser> {

	private static final long serialVersionUID = -2132691442L;

	public static final QRoleUser dRoleUser = new QRoleUser("dRoleUser");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final SetPath<RoleFunction, QRoleFunction> DRoleFunctions = this.<RoleFunction, QRoleFunction>createSet(
			"DRoleFunctions", RoleFunction.class, QRoleFunction.class, PathInits.DIRECT2);

	public final SetPath<UserApp, QUserApp> DUserApps = this.<UserApp, QUserApp>createSet("DUserApps",
			UserApp.class, QUserApp.class, PathInits.DIRECT2);

	// inherited
	public final NumberPath<Long> id = _super.id;

	public final StringPath roleCode = createString("roleCode");

	public final StringPath roleDescription = createString("roleDescription");

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

	public QRoleUser(String variable) {
		super(RoleUser.class, forVariable(variable));
	}

	public QRoleUser(Path<? extends RoleUser> path) {
		super(path.getType(), path.getMetadata());
	}

	public QRoleUser(PathMetadata metadata) {
		super(RoleUser.class, metadata);
	}

}
