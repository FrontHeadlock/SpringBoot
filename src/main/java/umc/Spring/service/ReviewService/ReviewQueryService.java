package umc.Spring.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.Spring.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {

    Optional<Review> findReview(Long id);
    List<Review> findReviewsById(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
