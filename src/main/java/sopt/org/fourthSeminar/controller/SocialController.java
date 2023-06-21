package sopt.org.fourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.request.SocialLoginRequestDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.service.SocialService;
import sopt.org.fourthSeminar.service.SocialServiceProvider;
import sopt.org.fourthSeminar.service.dto.request.SocialLoginRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/social")
public class SocialController {

    private final SocialServiceProvider socialServiceProvider;

    @PostMapping("/login")
    public ApiResponse<Long> login(@RequestHeader("code") String code, @RequestBody SocialLoginRequestDto request) {
        SocialService socialService = socialServiceProvider.getSocialService(request.getSocialPlatform());
        return ApiResponse.success(Success.SOCIAL_LOGIN_SUCCESS, socialService.login(SocialLoginRequest.of(code)));
    }
}
