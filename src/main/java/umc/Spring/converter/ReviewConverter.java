package umc.Spring.converter;

import umc.Spring.domain.Review;
import umc.Spring.domain.Store;
import umc.Spring.domain.User;
import umc.Spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.Spring.web.dto.reviewDTO.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO requestDto, User user, Store store) {
        return Review.builder()
                .title(requestDto.getTitle())
                .score(requestDto.getScore())
                .user(user)
                .parentReview(null)
                .build();
    }

    public static ReviewResponseDTO toResponseDto(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberName(review.getUser().getName())
                .storeName(review.getUser().getAddress())
                .build();
    }
}