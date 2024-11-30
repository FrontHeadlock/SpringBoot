package umc.Spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 493499031L;

    public static final QUser user = new QUser("user");

    public final umc.Spring.domain.common.QBaseEntity _super = new umc.Spring.domain.common.QBaseEntity(this);

    public final StringPath Address = createString("Address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.Spring.domain.enums.Gender> gender = createEnum("gender", umc.Spring.domain.enums.Gender.class);

    public final ListPath<Home, QHome> homeList = this.<Home, QHome>createList("homeList", Home.class, QHome.class, PathInits.DIRECT2);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.Spring.domain.mapping.MemberMission, umc.Spring.domain.mapping.QMemberMission> memberMissionList = this.<umc.Spring.domain.mapping.MemberMission, umc.Spring.domain.mapping.QMemberMission>createList("memberMissionList", umc.Spring.domain.mapping.MemberMission.class, umc.Spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.Spring.domain.mapping.MemberPrefer, umc.Spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.Spring.domain.mapping.MemberPrefer, umc.Spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.Spring.domain.mapping.MemberPrefer.class, umc.Spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.Spring.domain.enums.MemberStatus> status = createEnum("status", umc.Spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

