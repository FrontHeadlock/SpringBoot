package umc.Spring.repository.Home;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.Spring.domain.QHome;

import java.util.List;

import static umc.Spring.domain.QHome.home;

@Repository
@RequiredArgsConstructor

public class HomeRepositoryImpl implements HomeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QHome Home = home;

    @Override
    public List<umc.Spring.domain.Home> dynamicQueryWithBooleanBuilder(Long id, String name) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (name != null) {
            predicate.and(home.name.eq(name));
        }

        if (id != null && id>0) {
            predicate.and(home.id.eq(id));
        }

        return jpaQueryFactory
                .selectFrom(home)
                .where(predicate)
                .fetch();
    }
}