package umc.Spring.converter;

import umc.Spring.domain.Mission;
import umc.Spring.domain.Store;
import umc.Spring.web.dto.missionDTO.MissionRequestDTO;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

public class MissionConverter {

    public static Mission toEntity(MissionRequestDTO requestDto, Store store) {
        return Mission.builder()
                .mission_point(requestDto.getMission_point())
                .expire_date(requestDto.getExpire_date())
                .missionSpec(requestDto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponseDto(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .mission_point(mission.getMission_point())
                .expire_date(mission.getExpire_date())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .build();
    }
}