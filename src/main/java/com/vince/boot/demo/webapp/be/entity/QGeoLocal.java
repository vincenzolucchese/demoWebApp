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
 * QDGeoLocal is a Querydsl query type for DGeoLocal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoLocal extends EntityPathBase<GeoLocal> {

	private static final long serialVersionUID = -50312377L;

	public static final QGeoLocal dGeoLocal = new QGeoLocal("dGeoLocal");

	public final QBaseEntity _super = new QBaseEntity(this);

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

	public QGeoLocal(String variable) {
		super(GeoLocal.class, forVariable(variable));
	}

	public QGeoLocal(Path<? extends GeoLocal> path) {
		super(path.getType(), path.getMetadata());
	}

	public QGeoLocal(PathMetadata metadata) {
		super(GeoLocal.class, metadata);
	}

}
