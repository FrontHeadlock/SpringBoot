package umc.Spring.converter;

import org.springframework.data.domain.Page;
import umc.Spring.domain.Mission;
import umc.Spring.domain.Store;
import umc.Spring.web.dto.missionDTO.MissionRequestDTO;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

import java.util.List;

public class MissionConverter {

    // MissionRequestDTO -> Mission 엔티티 변환
    public static Mission toEntity(MissionRequestDTO requestDto, Store store) {
        return Mission.builder()
                .mission_point(requestDto.getMission_point())
                .expire_date(requestDto.getExpire_date())
                .missionSpec(requestDto.getMissionSpec())
                .store(store)
                .build();
    }

    // Mission 엔티티 -> MissionResponseDTO 변환
    public static MissionResponseDTO toResponseDto(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .mission_point(mission.getMission_point())
                .expire_date(mission.getExpire_date())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .build();
    }

    // Mission 엔티티 -> MissionPreviewDTO 변환
    public static MissionResponseDTO.MissionPreviewDTO toPreviewDto(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .id(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .missionPoint(mission.getMission_point())
                .expireDate(mission.getExpire_date())
                .status(mission.getStatus()) // MissionStatus 추가
                .build();
    }

    // Page<Mission> -> MissionListDTO 변환
    public static MissionResponseDTO.MissionListDTO toMissionListDTO(Page<Mission> missions) {
        // MissionPreviewDTO 리스트로 변환
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviews = missions.stream()
                .map(MissionConverter::toPreviewDto)
                .toList();

        // MissionListDTO 생성
        return MissionResponseDTO.MissionListDTO.builder()
                .missions(missionPreviews)
                .totalPages(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
