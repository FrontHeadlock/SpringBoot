package umc.Spring.repository.reviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.Spring.domain.Review;
import umc.Spring.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

}
