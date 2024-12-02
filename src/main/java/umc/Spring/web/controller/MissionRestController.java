package umc.Spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.Spring.apiPayload.ApiResponse;
import umc.Spring.converter.MissionConverter;
import umc.Spring.service.MissionService.MissionCommandService;
import umc.Spring.service.MissionService.MissionQueryService;
import umc.Spring.web.dto.missionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping
public class MissionRestController {

    private final MissionQueryService missionQueryService;

    @GetMapping("/ongoing")
    @Operation(summary = "진행 중인 미션 목록 조회 API", description = "현재 사용자가 진행 중인 미션 목록을 페이징하여 반환합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 제공해야 합니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰이 만료되었습니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 올바르지 않습니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, query parameter 입니다.")
    })
    public ApiResponse<MissionResponseDTO.MissionListDTO> getOngoingMissions(
            @RequestParam(name = "page", defaultValue = "0") Integer page) {
        MissionResponseDTO.MissionListDTO ongoingMissions = missionQueryService.getOngoingMissions(page.longValue(), page);
        return ApiResponse.onSuccess(ongoingMissions);
    }

    private final MissionCommandService missionCommandService;

    @PatchMapping("/{missionId}/complete")
    @Operation(summary = "진행 중인 미션 완료 처리 API", description = "현재 진행 중인 미션을 완료 상태로 변경합니다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 제공해야 합니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰이 만료되었습니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 모양이 올바르지 않습니다!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "missionId", description = "완료할 미션의 ID, path variable 입니다.")
    })
    public ApiResponse<Void> completeMission(@PathVariable Long missionId) {
        missionCommandService.completeMission(missionId);
        return ApiResponse.onSuccess(null);
    }

}
