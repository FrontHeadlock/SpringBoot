package umc.Spring.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.Spring.apiPayload.code.ErrorStatus;
import umc.Spring.apiPayload.exception.GeneralException;
import umc.Spring.converter.MissionConverter;
import umc.Spring.domain.enums.MissionStatus;
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

    @Override
    public void completeMission(Long missionId) {
        // 미션 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        // 현재 상태가 CHALLENGING이 아닌 경우 예외 발생
        if (mission.getStatus() != MissionStatus.CHALLENGING) {
            throw new GeneralException(ErrorStatus.MISSION_NOT_FOUND);
        }

        // 상태를 COMPLETE로 변경
        mission.setStatus(MissionStatus.COMPLETE);
    }
}