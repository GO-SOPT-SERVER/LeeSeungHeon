package sopt.org.fourthSeminar.service.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmotionServiceDto {

    private LocalDate recordDate;

    private String emotionContent;

    private int positive;

    private int negative;

    private int neutral;

    private String analysis;

    private String emotionType;

    public static EmotionServiceDto of(LocalDate recordDate, String emotionContent, int positive, int negative, int neutral, String analysis, String emotionType) {
        return new EmotionServiceDto(recordDate, emotionContent, positive, negative, neutral, analysis, emotionType);
    }
}
