package sopt.org.fourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSeminar.common.dto.ApiResponse;
import sopt.org.fourthSeminar.controller.dto.request.EmotionRequestDto;
import sopt.org.fourthSeminar.controller.dto.response.EmotionCalendarResponseDto;
import sopt.org.fourthSeminar.controller.dto.response.EmotionResponseDto;
import sopt.org.fourthSeminar.exception.Success;
import sopt.org.fourthSeminar.service.EmotionService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emotion")
public class EmotionController {

    private final EmotionService emotionService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@RequestBody @Valid final EmotionRequestDto request) {
        emotionService.create(request.toServiceDto());
        return ApiResponse.success(Success.CREATE_EMOTION_SUCCESS);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<EmotionCalendarResponseDto>> getCalendar(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") final LocalDate date) {
        return ApiResponse.success(Success.GET_EMOTION_CALENDAR_SUCCESS, emotionService.getCalendar(date));
    }

    @GetMapping("{emotionId}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<EmotionResponseDto> getOne(@PathVariable final Long emotionId) {
        return ApiResponse.success(Success.GET_EMOTION_SUCCESS, emotionService.getOne(emotionId));
    }
}
