package umc.Spring.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.Spring.domain.QRegion;
import umc.Spring.domain.Region;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QRegion region = QRegion.region;

    @Override
    public List<Region> dynamicQueryWithBooleanBuilder(String name, Long id) {
        BooleanBuilder predicate = new BooleanBuilder();  // BooleanBuilder 초기화

        if (name != null) {
            predicate.and(region.name.eq(name));
        }

        if (id != null) {
            predicate.and(region.id.goe(4L));  // id는 Long 타입으로 비교
        }

        return jpaQueryFactory
                .selectFrom(region)
                .where(predicate)
                .fetch();
    }
}