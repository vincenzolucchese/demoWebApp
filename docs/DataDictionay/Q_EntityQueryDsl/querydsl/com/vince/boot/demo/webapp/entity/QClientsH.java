package com.vince.boot.demo.webapp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClientsH is a Querydsl query type for ClientsH
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientsH extends EntityPathBase<ClientsH> {

    private static final long serialVersionUID = 1550373367L;

    public static final QClientsH clientsH = new QClientsH("clientsH");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> timeInsert = createDateTime("timeInsert", java.util.Date.class);

    public final DateTimePath<java.util.Date> timeUpdate = createDateTime("timeUpdate", java.util.Date.class);

    public final NumberPath<Integer> userInsert = createNumber("userInsert", Integer.class);

    public final NumberPath<Integer> userUpdate = createNumber("userUpdate", Integer.class);

    public QClientsH(String variable) {
        super(ClientsH.class, forVariable(variable));
    }

    public QClientsH(Path<? extends ClientsH> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClientsH(PathMetadata metadata) {
        super(ClientsH.class, metadata);
    }

}

