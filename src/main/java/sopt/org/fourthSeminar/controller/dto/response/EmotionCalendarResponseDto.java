package sopt.org.fourthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmotionCalendarResponseDto {

    private Long emotionId;

    private LocalDate recordDate;

    private String emotionType;

    public static EmotionCalendarResponseDto of(Long emotionId, LocalDate recordDate, String emotionType) {
        return new EmotionCalendarResponseDto(emotionId, recordDate, emotionType);
    }
}
