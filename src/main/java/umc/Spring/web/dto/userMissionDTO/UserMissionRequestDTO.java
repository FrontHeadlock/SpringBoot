package umc.Spring.web.dto.userMissionDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import umc.Spring.validation.annotation.NotChallenged;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMissionRequestDTO {
    @NotChallenged // 커스텀 유효성 검사: 이미 도전 중인 미션인지 검증
    private Long memberId; // 도전하는 사용자 ID

    private Long missionId; // 도전할 미션 ID
}
