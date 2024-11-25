package umc.Spring.service.UserService;

import jakarta.transaction.Transactional;
import umc.Spring.domain.User;
import umc.Spring.web.dto.memberDTO.MemberRequestDTO;

public interface UserCommandService {
    @Transactional
    User joinMember(MemberRequestDTO.JoinDto request);
}