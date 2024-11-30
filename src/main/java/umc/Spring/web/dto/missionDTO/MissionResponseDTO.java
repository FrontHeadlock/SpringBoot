package umc.Spring.web.dto.missionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.Spring.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MissionResponseDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MissionListDTO {
        List<MissionPreviewDTO> missions;
        Integer totalPages;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MissionPreviewDTO {
        private Long id;
        private String missionSpec;  // 미션 설명
        private String storeName;    // 미션이 속한 가게 이름
        private Integer missionPoint; // 미션 포인트
        private LocalDate expireDate; // 미션 만료일
        private MissionStatus status; // 진행 상태
    }

    private Long id;
    private Integer mission_point;
    private LocalDate expire_date;
    private String missionSpec;
    private String storeName; // 미션이 속한 가게의 이름

}