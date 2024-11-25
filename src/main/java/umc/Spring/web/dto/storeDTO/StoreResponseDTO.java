package umc.Spring.web.dto.storeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreResponseDTO {
    private Long id;
    private String name;
    private String address;
    private Float score;
    private String regionName;
}