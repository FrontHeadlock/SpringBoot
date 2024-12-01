// MissionQueryServiceImpl.java
package umc.Spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.apiPayload.code.ErrorStatus;
import umc.Spring.apiPayload.exception.GeneralException;
import umc.Spring.domain.Mission;
import umc.Spring.domain.User;
import umc.Spring.domain.enums.MissionStatus;
import umc.Spring.repository.missionRepository.MissionRepository;
import umc.Spring.repository.userRepository.UserRepository;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionsByIdAndSpec(String missionSpec, Long id) {
        List<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(id, missionSpec);

        filteredMissions.forEach(mission -> System.out.println("Mission: " + mission));

        return filteredMissions;
    }

    @Override
    public MissionResponseDTO.MissionListDTO getOngoingMissions(Long missionId, Integer page) {
        // 현재 로그인한 사용자 정보를 가져오는 메서드
        User currentUser = getCurrentUser();

        // 페이징 요청 생성
        PageRequest pageRequest = PageRequest.of(page, 10);

        // 진행 중인 미션 조회
        Page<Mission> ongoingMissions = missionRepository.findAllByUserAndStatus(currentUser, MissionStatus.CHALLENGING, pageRequest);

        // DTO 변환
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviews = ongoingMissions.stream()
                .map(mission -> MissionResponseDTO.MissionPreviewDTO.builder()
                        .id(mission.getId())
                        .missionSpec(mission.getMissionSpec())
                        .storeName(mission.getStore().getName())
                        .missionPoint(mission.getMissionPoint())
                        .expireDate(mission.getExpireDate())
                        .status(mission.getStatus())
                        .build())
                .toList();

        // MissionListDTO 생성
        return MissionConverter.toMissionListDTO(ongoingMissions);
    }

    private User getCurrentUser() {
        // 현재 사용자를 가져오는 메서드 (SecurityContextHolder 활용 예)
        return userRepository.findById(1L) // 현재 사용자를 1번 사용자로 가정한 예제
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
    }
}

