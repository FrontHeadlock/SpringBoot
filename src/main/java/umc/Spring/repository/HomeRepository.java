package umc.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Home;
import umc.Spring.domain.Mission;

public interface HomeRepository extends JpaRepository<Home, Long>,HomeRepositoryCustom {
}