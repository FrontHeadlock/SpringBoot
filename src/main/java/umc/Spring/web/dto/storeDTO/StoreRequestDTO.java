package umc.Spring.web.dto.storeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StoreRequestDTO {
    private String name;
    private String address;
    private Long regionId; // 특정 지역 ID를 통해서 지역 지정
}