package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseEntity is a Querydsl query type for BaseEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBaseEntity extends EntityPathBase<BaseEntity> {

    private static final long serialVersionUID = 1522760459L;

    public static final QBaseEntity baseEntity = new QBaseEntity("baseEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> timeInsert = createDateTime("timeInsert", java.util.Date.class);

    public final DateTimePath<java.util.Date> timeUpdate = createDateTime("timeUpdate", java.util.Date.class);

    public final StringPath userInsert = createString("userInsert");

    public final StringPath userUpdate = createString("userUpdate");

    public final DateTimePath<java.util.Date> yearRefer = createDateTime("yearRefer", java.util.Date.class);

    public QBaseEntity(String variable) {
        super(BaseEntity.class, forVariable(variable));
    }

    public QBaseEntity(Path<? extends BaseEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseEntity(PathMetadata metadata) {
        super(BaseEntity.class, metadata);
    }

}

