package umc.Spring.converter;

import umc.Spring.domain.User;
import umc.Spring.domain.enums.Gender;
import umc.Spring.web.dto.memberDTO.MemberRequestDTO;
import umc.Spring.web.dto.memberDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .userId(user.getUser_id())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
