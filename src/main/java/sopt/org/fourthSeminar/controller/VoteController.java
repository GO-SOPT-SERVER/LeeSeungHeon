package sopt.org.fourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.request.VoteRequestDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.service.VoteService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("vote")
@CrossOrigin("*")
public class VoteController {

    private final VoteService voteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@RequestBody @Valid VoteRequestDto request) {
        voteService.create(request);
        return ApiResponse.success(Success.CREATE_VOTE_SUCCESS);
    }
}
