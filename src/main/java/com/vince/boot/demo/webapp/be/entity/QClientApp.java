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
 * QDClientApp is a Querydsl query type for DClientApp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientApp extends EntityPathBase<ClientApp> {

	private static final long serialVersionUID = 375163721L;

	public static final QClientApp dClientApp = new QClientApp("dClientApp");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final StringPath address = createString("address");

	public final SetPath<OrderJob, QOrderJob> DOrderJobs = this.<OrderJob, QOrderJob>createSet("DOrderJobs",
			OrderJob.class, QOrderJob.class, PathInits.DIRECT2);

	public final SetPath<RelClientBlob, QRelClientBlob> DRelClientBlobs = this
			.<RelClientBlob, QRelClientBlob>createSet("DRelClientBlobs", RelClientBlob.class, QRelClientBlob.class,
					PathInits.DIRECT2);

	public final StringPath email = createString("email");

	// inherited
	public final NumberPath<Long> id = _super.id;

	public final StringPath name = createString("name");

	public final StringPath notes = createString("notes");

	public final StringPath phone = createString("phone");

	public final StringPath piva = createString("piva");

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

	public final StringPath zipcode = createString("zipcode");

	public QClientApp(String variable) {
		super(ClientApp.class, forVariable(variable));
	}

	public QClientApp(Path<? extends ClientApp> path) {
		super(path.getType(), path.getMetadata());
	}

	public QClientApp(PathMetadata metadata) {
		super(ClientApp.class, metadata);
	}

}
