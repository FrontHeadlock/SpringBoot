package umc.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
}
