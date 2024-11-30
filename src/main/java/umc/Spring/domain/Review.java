package umc.Spring.domain;


import jakarta.persistence.*;
import lombok.*;
import umc.Spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 5)
    private Float score;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "parent_review_id") // Review 간 관계
    private Review parentReview;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    public void setMember(User user){
        if(this.user != null)
            user.getReviewList().remove(this);
        this.user = user;
        user.getReviewList().add(this);
    }

    /*public void setStore(Store store){
        if (this.score != null)
            store.getReviewList().remove(this);
        this.store = store;
        store.getReviewList().add(this);
    }*/

}
