package umc.Spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.Spring.apiPayload.code.ErrorStatus;
import umc.Spring.apiPayload.exception.handler.StoreHandler;
import umc.Spring.converter.StoreConverter;
import umc.Spring.domain.Region;
import umc.Spring.domain.Store;
import umc.Spring.repository.regionRepository.RegionRepository;
import umc.Spring.repository.storeRepository.StoreRepository;
import umc.Spring.web.dto.storeDTO.StoreRequestDTO;
import umc.Spring.web.dto.storeDTO.StoreResponseDTO;

import static umc.Spring.domain.QRegion.region;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreResponseDTO addStore(StoreRequestDTO requestDto) {

        // Region 조회 (존재하지 않으면 예외 발생)
        Region region = regionRepository.findById(requestDto.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));


        // DTO를 Entity로 변환 후 저장
        Store store = StoreConverter.toEntity(requestDto, region);
        Store savedStore = storeRepository.save(store);

        // Entity를 Response DTO로 변환 후 반환
        return StoreConverter.toResponseDto(savedStore);
    }
}