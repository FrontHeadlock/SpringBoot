package umc.Spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.Spring.apiPayload.code.ErrorStatus;
import umc.Spring.apiPayload.exception.GeneralException;
import umc.Spring.converter.MissionConverter;
import umc.Spring.repository.missionRepository.MissionRepository;
import umc.Spring.repository.storeRepository.StoreRepository;
import umc.Spring.domain.Mission;
import umc.Spring.domain.Store;
import umc.Spring.web.dto.missionDTO.MissionRequestDTO;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

@Service
@RequiredArgsConstructor

public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO requestDto) {

        Store store = storeRepository.findById(requestDto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        Mission mission = MissionConverter.toEntity(requestDto, store);
        Mission savedMission = missionRepository.save(mission);

        return MissionConverter.toResponseDto(savedMission);
    }
}