package sopt.org.fourthSeminar.controller.dto.request;

import lombok.*;
import sopt.org.fourthSeminar.domain.SocialPlatform;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SocialLoginRequestDto {

    private SocialPlatform socialPlatform;
}
