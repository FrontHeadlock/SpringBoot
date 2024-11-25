package umc.Spring.converter;

import umc.Spring.domain.Mission;
import umc.Spring.domain.User;
import umc.Spring.domain.enums.MissionStatus;
import umc.Spring.domain.mapping.MemberMission;
import umc.Spring.web.dto.userMissionDTO.UserMissionRequestDTO;
import umc.Spring.web.dto.userMissionDTO.UserMissionResponseDTO;

public class UserMissionConverter {

    public static MemberMission toEntity(UserMissionRequestDTO requestDto, User user, Mission mission) {
        return MemberMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 기본 상태는 도전 중 (CHALLENGING)
                .build();
    }

    public static UserMissionResponseDTO toResponseDto(MemberMission memberMission) {
        return UserMissionResponseDTO.builder()
                .id(memberMission.getId())
                .memberId(memberMission.getUser().getUser_id())
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }
}
