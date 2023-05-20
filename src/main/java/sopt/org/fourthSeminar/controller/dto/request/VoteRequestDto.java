package sopt.org.fourthSeminar.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VoteRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String part;

    @NotNull
    private List<Boolean> voteList;
}
