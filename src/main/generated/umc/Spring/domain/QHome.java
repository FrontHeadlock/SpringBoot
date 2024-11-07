package umc.Spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHome is a Querydsl query type for Home
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHome extends EntityPathBase<Home> {

    private static final long serialVersionUID = 493108139L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHome home = new QHome("home");

    public final umc.Spring.domain.common.QBaseEntity _super = new umc.Spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> expire_date = createNumber("expire_date", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final QMission mission;

    public final StringPath name = createString("name");

    public final QRegion region;

    public final EnumPath<umc.Spring.domain.enums.MemberStatus> status = createEnum("status", umc.Spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QHome(String variable) {
        this(Home.class, forVariable(variable), INITS);
    }

    public QHome(Path<? extends Home> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHome(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHome(PathMetadata metadata, PathInits inits) {
        this(Home.class, metadata, inits);
    }

    public QHome(Class<? extends Home> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region"), inits.get("region")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

