package umc.Spring.repository.missionRepository;

import umc.Spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryWithBooleanBuilder(Long id,String missionSpec);
}
