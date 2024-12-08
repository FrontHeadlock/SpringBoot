package umc.Spring.repository.missionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Mission;
import umc.Spring.domain.User;
import umc.Spring.domain.enums.MissionStatus;
import org.springframework.data.domain.Pageable;

public interface MissionRepository extends JpaRepository<Mission, Long>,MissionRepositoryCustom {
    Page<Mission> findAllByUserAndStatus(User user, MissionStatus status, Pageable pageable);

}
