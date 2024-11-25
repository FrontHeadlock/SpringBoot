package umc.Spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.Spring.apiPayload.code.ErrorStatus;
import umc.Spring.apiPayload.exception.GeneralException;
import umc.Spring.converter.ReviewConverter;
import umc.Spring.domain.User;
import umc.Spring.repository.storeRepository.StoreRepository;


import umc.Spring.repository.reviewRepository.ReviewRepository;
import umc.Spring.repository.userRepository.UserRepository;
import umc.Spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.Spring.web.dto.reviewDTO.ReviewResponseDTO;
import umc.Spring.domain.Store;
import umc.Spring.domain.Review;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewResponseDTO addReview(ReviewRequestDTO requestDto) {
        // Member 조회 (존재하지 않으면 예외 발생)
        User user = userRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // Store 조회 (존재하지 않으면 예외 발생)
        Store store = storeRepository.findById(requestDto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        // DTO를 Entity로 변환 후 저장
        Review review = ReviewConverter.toEntity(requestDto, user, store);
        Review savedReview = reviewRepository.save(review);

        // Entity를 Response DTO로 변환 후 반환
        return ReviewConverter.toResponseDto(savedReview);
    }
}
