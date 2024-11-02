package umc.Spring.domain;


import jakarta.persistence.*;
import umc.Spring.domain.common.BaseEntity;
import umc.Spring.domain.enums.Gender;
import umc.Spring.domain.enums.MemberStatus;
import umc.Spring.domain.mapping.MemberMission;
import lombok.*;
import umc.Spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false,length = 40)
    private String Address;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    private Integer point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Home> homeList = new ArrayList<>();
}
