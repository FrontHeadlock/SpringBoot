package umc.Spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMission is a Querydsl query type for Mission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMission extends EntityPathBase<Mission> {

    private static final long serialVersionUID = 1373255488L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMission mission = new QMission("mission");

    public final umc.Spring.domain.common.QBaseEntity _super = new umc.Spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DatePath<java.time.LocalDate> expire_date = createDate("expire_date", java.time.LocalDate.class);

    public final ListPath<Home, QHome> homeList = this.<Home, QHome>createList("homeList", Home.class, QHome.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.Spring.domain.mapping.MemberMission, umc.Spring.domain.mapping.QMemberMission> memberMissionList = this.<umc.Spring.domain.mapping.MemberMission, umc.Spring.domain.mapping.QMemberMission>createList("memberMissionList", umc.Spring.domain.mapping.MemberMission.class, umc.Spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final NumberPath<Integer> mission_point = createNumber("mission_point", Integer.class);

    public final StringPath missionSpec = createString("missionSpec");

    public final EnumPath<umc.Spring.domain.enums.MissionStatus> status = createEnum("status", umc.Spring.domain.enums.MissionStatus.class);

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMission(String variable) {
        this(Mission.class, forVariable(variable), INITS);
    }

    public QMission(Path<? extends Mission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMission(PathMetadata metadata, PathInits inits) {
        this(Mission.class, metadata, inits);
    }

    public QMission(Class<? extends Mission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

