package umc.Spring.converter;

import umc.Spring.domain.Region;
import umc.Spring.domain.Store;
import umc.Spring.web.dto.storeDTO.StoreRequestDTO;
import umc.Spring.web.dto.storeDTO.StoreResponseDTO;

public class StoreConverter {

    public static Store toEntity(StoreRequestDTO requestDto, Region region) {
        return Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .region(region)
                .score(0.0f)
                .build();
    }

    public static StoreResponseDTO toResponseDto(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .regionName(store.getRegion() != null ? store.getRegion().getName() : "N/A")
                .build();
    }

}