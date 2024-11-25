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

public class MissionRequestDTO {
    private Integer mission_point;
    private LocalDate expire_date;
    private String missionSpec;
    private Long storeId;

}
