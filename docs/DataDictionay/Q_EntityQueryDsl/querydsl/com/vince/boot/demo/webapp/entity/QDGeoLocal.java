package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDGeoLocal is a Querydsl query type for DGeoLocal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDGeoLocal extends EntityPathBase<DGeoLocal> {

    private static final long serialVersionUID = -50312377L;

    public static final QDGeoLocal dGeoLocal = new QDGeoLocal("dGeoLocal");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> timeInsert = _super.timeInsert;

    //inherited
    public final DateTimePath<java.util.Date> timeUpdate = _super.timeUpdate;

    //inherited
    public final StringPath userInsert = _super.userInsert;

    //inherited
    public final StringPath userUpdate = _super.userUpdate;

    //inherited
    public final DateTimePath<java.util.Date> yearRefer = _super.yearRefer;

    public QDGeoLocal(String variable) {
        super(DGeoLocal.class, forVariable(variable));
    }

    public QDGeoLocal(Path<? extends DGeoLocal> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDGeoLocal(PathMetadata metadata) {
        super(DGeoLocal.class, metadata);
    }

}

