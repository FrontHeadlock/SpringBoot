// MissionQueryServiceImpl.java
package umc.Spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.Mission;
import umc.Spring.repository.missionRepository.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public List<Mission> findMissionsByIdAndSpec(String missionSpec, Long id) {
        List<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(id,missionSpec);

        filteredMissions.forEach(mission -> System.out.println("Mission:" + mission));

        return filteredMissions;
    }
}

