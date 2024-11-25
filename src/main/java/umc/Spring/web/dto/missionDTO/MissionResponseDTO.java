package umc.Spring.web.dto.missionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MissionResponseDTO {
    private Long id;
    private Integer mission_point;
    private LocalDate expire_date;
    private String missionSpec;
    private String storeName; // 미션이 속한 가게의 이름

}