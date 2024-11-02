package umc.Spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.Spring.domain.common.BaseEntity;
import umc.Spring.domain.enums.MemberStatus;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Home extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long expire_date;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDate inactiveDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name= "mission_id",nullable = false)
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;


}
