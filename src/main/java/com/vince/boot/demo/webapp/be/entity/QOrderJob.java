package com.vince.boot.demo.webapp.be.entity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QDOrderJob is a Querydsl query type for DOrderJob
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderJob extends EntityPathBase<OrderJob> {

	private static final long serialVersionUID = -631852484L;

	private static final PathInits INITS = PathInits.DIRECT2;

	public static final QOrderJob dOrderJob = new QOrderJob("dOrderJob");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final StringPath address = createString("address");

	public final StringPath codeOrder = createString("codeOrder");

	public final DateTimePath<java.util.Date> dataScadenza = createDateTime("dataScadenza", java.util.Date.class);

	public final QClientApp DClientApp;

	public final SetPath<RelOrderBlob, QRelOrderBlob> DRelOrderBlobs = this.<RelOrderBlob, QRelOrderBlob>createSet(
			"DRelOrderBlobs", RelOrderBlob.class, QRelOrderBlob.class, PathInits.DIRECT2);

	public final NumberPath<java.math.BigDecimal> finalAmount = createNumber("finalAmount", java.math.BigDecimal.class);

	public final ComparablePath<Character> flagActive = createComparable("flagActive", Character.class);

	// inherited
	public final NumberPath<Long> id = _super.id;

	public final StringPath notes = createString("notes");

	public final NumberPath<java.math.BigDecimal> preAmount = createNumber("preAmount", java.math.BigDecimal.class);

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

	public QOrderJob(String variable) {
		this(OrderJob.class, forVariable(variable), INITS);
	}

	public QOrderJob(Path<? extends OrderJob> path) {
		this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
	}

	public QOrderJob(PathMetadata metadata) {
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QOrderJob(PathMetadata metadata, PathInits inits) {
		this(OrderJob.class, metadata, inits);
	}

	public QOrderJob(Class<? extends OrderJob> type, PathMetadata metadata, PathInits inits) {
		super(type, metadata, inits);
		this.DClientApp = inits.isInitialized("DClientApp") ? new QClientApp(forProperty("DClientApp")) : null;
	}

}
