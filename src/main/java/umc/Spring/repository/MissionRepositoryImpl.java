package umc.Spring.repository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.Spring.domain.Mission;
import umc.Spring.domain.QMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission qmission = QMission.mission;

    public List<Mission> dynamicQueryWithBooleanBuilder (Long id,String missionSpec) {
        BooleanBuilder predicate = new BooleanBuilder();
        if (missionSpec != null) {
            predicate.and(qmission.missionSpec.eq(missionSpec));
        }

        if(id != 0 && id>0) {
            predicate.and(qmission.id.eq(id));
        }

        return jpaQueryFactory
                .selectFrom(qmission)
                .where(predicate)
                .fetch();
    }
}
