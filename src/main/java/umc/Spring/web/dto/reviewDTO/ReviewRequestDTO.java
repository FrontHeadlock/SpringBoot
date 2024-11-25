package umc.Spring.web.dto.reviewDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewRequestDTO {

    private String title;
    private Float score;

    @ExistStore
    private Long storeId; // 가게 ID

    private Long memberId; // 리뷰 작성자 ID
}