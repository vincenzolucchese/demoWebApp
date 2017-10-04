package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGeoLocal is a Querydsl query type for GeoLocal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGeoLocal extends EntityPathBase<GeoLocal> {

    private static final long serialVersionUID = -1837178543L;

    public static final QGeoLocal geoLocal = new QGeoLocal("geoLocal");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> timeInsert = createDateTime("timeInsert", java.util.Date.class);

    public final DateTimePath<java.util.Date> timeUpdate = createDateTime("timeUpdate", java.util.Date.class);

    public final NumberPath<Integer> userInsert = createNumber("userInsert", Integer.class);

    public final NumberPath<Integer> userUpdate = createNumber("userUpdate", Integer.class);

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

