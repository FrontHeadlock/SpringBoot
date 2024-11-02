package umc.Spring.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import umc.Spring.domain.common.BaseEntity;

import jakarta.persistence.*;
import lombok.*;
import umc.Spring.domain.common.BaseEntity;
import umc.Spring.domain.enums.MemberStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Mission> missions = new ArrayList<>();
}
