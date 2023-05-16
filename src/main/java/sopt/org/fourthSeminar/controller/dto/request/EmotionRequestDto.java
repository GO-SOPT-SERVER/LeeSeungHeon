package sopt.org.fourthSeminar.controller.dto.request;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import sopt.org.fourthSeminar.service.dto.request.EmotionServiceDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmotionRequestDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;

    @NotBlank
    private String emotionContent;

    @NotNull
    private int positive;

    @NotNull
    private int negative;

    @NotNull
    private int neutral;

    @NotBlank
    private String analysis;

    @NotNull
    private String emotionType;

    public EmotionServiceDto toServiceDto() {
        return EmotionServiceDto.of(recordDate, emotionContent, positive, negative, neutral, analysis, emotionType);
    }
}
