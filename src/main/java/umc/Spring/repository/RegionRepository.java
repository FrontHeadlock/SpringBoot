package umc.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, RegionRepositoryCustom {
}
