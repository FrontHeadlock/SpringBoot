package umc.Spring.converter;

import org.springframework.data.domain.Page;
import umc.Spring.domain.Review;
import umc.Spring.domain.Store;
import umc.Spring.domain.User;
import umc.Spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.Spring.web.dto.reviewDTO.ReviewResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                //.body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewListDTO = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewListDTO.size())
                .reviewList(reviewPreviewListDTO)
                .build();
    }
}