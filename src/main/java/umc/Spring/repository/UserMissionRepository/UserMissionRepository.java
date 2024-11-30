package umc.Spring.repository.UserMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.mapping.MemberMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}