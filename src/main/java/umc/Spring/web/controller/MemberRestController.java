package umc.Spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import umc.Spring.apiPayload.ApiResponse;
import umc.Spring.converter.MemberConverter;
import umc.Spring.domain.User;
import umc.Spring.service.UserService.UserCommandService;
import umc.Spring.web.dto.memberDTO.MemberRequestDTO;
import umc.Spring.web.dto.memberDTO.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class MemberRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        User user = userCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(user));
    }
}