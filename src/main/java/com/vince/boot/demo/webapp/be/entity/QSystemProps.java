package com.vince.boot.demo.webapp.be.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QDSystemProps is a Querydsl query type for DSystemProps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSystemProps extends EntityPathBase<SystemProps> {

	private static final long serialVersionUID = -1592454988L;

	public static final QSystemProps dSystemProps = new QSystemProps("dSystemProps");

	public final QBaseEntity _super = new QBaseEntity(this);

	// inherited
	public final NumberPath<Long> id = _super.id;

	public final StringPath keyProp = createString("keyProp");

	// inherited
	public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

	// inherited
	public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

	// inherited
	public final StringPath userInsert = _super.userInsert;

	// inherited
	public final StringPath userUpdate = _super.userUpdate;

	public final StringPath valueProp = createString("valueProp");

	// inherited
	public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

	public QSystemProps(String variable) {
		super(SystemProps.class, forVariable(variable));
	}

	public QSystemProps(Path<? extends SystemProps> path) {
		super(path.getType(), path.getMetadata());
	}

	public QSystemProps(PathMetadata metadata) {
		super(SystemProps.class, metadata);
	}

}
