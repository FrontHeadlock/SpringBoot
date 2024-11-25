package umc.Spring.repository.Home;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Home;

public interface HomeRepository extends JpaRepository<Home, Long>,HomeRepositoryCustom {
}