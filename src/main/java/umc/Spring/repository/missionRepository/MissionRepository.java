package umc.Spring.repository.missionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>,MissionRepositoryCustom {
}
