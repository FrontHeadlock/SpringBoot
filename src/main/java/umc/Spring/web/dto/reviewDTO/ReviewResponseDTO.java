package umc.Spring.web.dto.reviewDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewResponseDTO {

    private Long id;
    private String title;
    private Float score;
    private String memberName; // 리뷰 작성자의 이름
    private String storeName;  // 가게 이름
}