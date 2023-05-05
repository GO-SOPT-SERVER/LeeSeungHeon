package sopt.org.fourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.response.PostResponseDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web-gallery")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PostResponseDto>> getList() {
        return ApiResponse.success(Success.GET_POST_LIST_SUCCESS, postService.getList());
    }

    @GetMapping("{postId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponseDto> getOne(@PathVariable final Long postId) {
        return ApiResponse.success(Success.GET_POST_SUCCESS, postService.getOne(postId));
    }
}
