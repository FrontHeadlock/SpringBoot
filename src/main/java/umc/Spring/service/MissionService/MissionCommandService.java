package umc.Spring.service.MissionService;

import umc.Spring.web.dto.missionDTO.MissionRequestDTO;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO addMission(MissionRequestDTO requestDto);
}