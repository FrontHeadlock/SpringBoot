package umc.Spring.repository.userRepository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.Spring.domain.QUser;
import umc.Spring.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;

    @Override
    public List<User> dynamicQueryWithBooleanBuilder(Long user_id, String name){
        BooleanBuilder predicate = new BooleanBuilder();
        if(name!= null){
            predicate.and(user.name.eq(name));
        }
        if(user_id != null && user_id > 0){
            predicate.and(user.user_id.eq(user_id));
        }

        return jpaQueryFactory
                .selectFrom(user)
                .where(predicate)
                .fetch();
    }
}
