package umc.Spring.domain.mapping;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import lombok.*;
import umc.Spring.domain.User;
import umc.Spring.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberPrefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
