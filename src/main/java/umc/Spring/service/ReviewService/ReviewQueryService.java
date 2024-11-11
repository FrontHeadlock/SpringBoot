package umc.Spring.service.ReviewService;

import umc.Spring.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {

    Optional<Review> findReview(Long id);
    List<Review> findReviewsById(Long id);
}
