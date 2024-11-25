package umc.Spring.web.dto.userMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String missionSpec; // 미션 설명
}