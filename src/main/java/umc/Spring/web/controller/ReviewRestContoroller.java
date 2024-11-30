package umc.Spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.Spring.apiPayload.ApiResponse;
import umc.Spring.converter.ReviewConverter;
import umc.Spring.domain.Review;
import umc.Spring.service.ReviewService.ReviewQueryService;
import umc.Spring.validation.annotation.ExistStore;
import umc.Spring.web.dto.reviewDTO.ReviewResponseDTO;
import umc.Spring.web.dto.storeDTO.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping
public class ReviewRestContoroller {
    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. queryString으로 page 번호를 주세요.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description="OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003",description = "access토큰을 주세요!"
            ,content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004",description = "access토큰 만료!"
            ,content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005",description = "access토큰 모양이 이상합니다"
            ,content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name="storeId", description = "가게의 아이디, path variable 입니다!")
    })

    public ApiResponse<ReviewResponseDTO.ReviewPreviewListDTO> getReviewList
            (@ExistStore @PathVariable(name="storeId") Long storeId,@RequestParam(name = "page") Integer page) {
        reviewQueryService.getReviewList(storeId,page);
        Page<Review> reviewList = reviewQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDTO(reviewList));
    }

}
