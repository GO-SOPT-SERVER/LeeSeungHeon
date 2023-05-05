package sopt.org.fourthSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long id;
    private String imgSrc;
    private String name;
    private String date;
    private String content;

    public static PostResponseDto of(Long id, String imgSrc, String name, String date, String content) {
        return new PostResponseDto(id, imgSrc, name, date, content);
    }
}
