package umc.Spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.Spring.domain.Review;
import umc.Spring.domain.Store;
import umc.Spring.repository.reviewRepository.ReviewRepository;
import umc.Spring.repository.storeRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final StoreRepository storeRepository;

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

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {

        Store store = storeRepository.findById(StoreId).get();


        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

}
