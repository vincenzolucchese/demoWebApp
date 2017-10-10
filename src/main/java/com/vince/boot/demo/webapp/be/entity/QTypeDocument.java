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
 * QDTypeDocument is a Querydsl query type for DTypeDocument
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTypeDocument extends EntityPathBase<TypeDocument> {

	private static final long serialVersionUID = 582667426L;

	public static final QTypeDocument dTypeDocument = new QTypeDocument("dTypeDocument");

	public final QBaseEntity _super = new QBaseEntity(this);

	public final SetPath<BlobStore, QBlobStore> DBlobStores = this.<BlobStore, QBlobStore>createSet("DBlobStores",
			BlobStore.class, QBlobStore.class, PathInits.DIRECT2);

	// inherited
	public final NumberPath<Long> id = _super.id;

	// inherited
	public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

	// inherited
	public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

	public final StringPath typeCode = createString("typeCode");

	public final StringPath typeDescription = createString("typeDescription");

	// inherited
	public final StringPath userInsert = _super.userInsert;

	// inherited
	public final StringPath userUpdate = _super.userUpdate;

	// inherited
	public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

	public QTypeDocument(String variable) {
		super(TypeDocument.class, forVariable(variable));
	}

	public QTypeDocument(Path<? extends TypeDocument> path) {
		super(path.getType(), path.getMetadata());
	}

	public QTypeDocument(PathMetadata metadata) {
		super(TypeDocument.class, metadata);
	}

}
