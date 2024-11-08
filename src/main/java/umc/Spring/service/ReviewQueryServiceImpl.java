package umc.Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.Review;
import umc.Spring.repository.ReviewRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findReview(Long id) {
        return reviewRepository.findById(id);
    }
    @Override
    public List<Review> findReviewsById(Long id) {
        List<Review> filteredReviews = reviewRepository.dynamicQueryWithBooleanBuilder(id);
        filteredReviews.forEach(review -> System.out.println("review: "+ review));
        return filteredReviews;

    }

}
