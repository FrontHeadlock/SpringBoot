package umc.Spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.Spring.domain.Mission;
import umc.Spring.domain.User;
import umc.Spring.domain.common.BaseEntity;
import umc.Spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "mission_id",nullable = false)
    private Mission mission;

}
