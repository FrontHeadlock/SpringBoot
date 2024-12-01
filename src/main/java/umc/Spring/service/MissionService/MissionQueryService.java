package umc.Spring.service.MissionService;

import umc.Spring.domain.Mission;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);
    List<Mission> findMissionsByIdAndSpec(String missionSpec, Long id);

    MissionResponseDTO.MissionListDTO getOngoingMissions(Long missionId, Integer page);
}
