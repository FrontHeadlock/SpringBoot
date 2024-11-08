package umc.Spring.service;

import umc.Spring.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);
    List<Mission> findMissionsByIdAndSpec(String missionSpec, Long id);
}
