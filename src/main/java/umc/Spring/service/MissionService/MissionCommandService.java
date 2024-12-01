package umc.Spring.service.MissionService;

import jakarta.validation.Valid;
import umc.Spring.web.dto.missionDTO.MissionRequestDTO;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO addMission(@Valid MissionRequestDTO requestDto);


    void completeMission(Long missionId);
}