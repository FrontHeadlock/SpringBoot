package umc.Spring.service.StoreService;

import umc.Spring.web.dto.storeDTO.StoreRequestDTO;
import umc.Spring.web.dto.storeDTO.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO addStore(StoreRequestDTO requestDto);
}
