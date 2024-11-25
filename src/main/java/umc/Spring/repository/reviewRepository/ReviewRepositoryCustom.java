package umc.Spring.repository.reviewRepository;

import umc.Spring.domain.Review;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> dynamicQueryWithBooleanBuilder (Long id);
}
