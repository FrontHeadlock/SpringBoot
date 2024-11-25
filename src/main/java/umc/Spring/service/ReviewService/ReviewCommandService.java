package umc.Spring.service.ReviewService;

import jakarta.validation.Valid;
import umc.Spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc.Spring.web.dto.reviewDTO.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO addReview(@Valid ReviewRequestDTO requestDto);
}
