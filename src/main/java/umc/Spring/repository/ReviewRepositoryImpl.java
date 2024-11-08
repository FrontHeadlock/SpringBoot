package umc.Spring.repository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.Spring.domain.QReview;
import umc.Spring.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    @Override
    public List<Review> dynamicQueryWithBooleanBuilder(Long id) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (id != null && id > 0) {
            predicate.and(review.id.eq(id));
        }
    return jpaQueryFactory
            .selectFrom(review)
            .where(predicate)
            .fetch();

    }
}
