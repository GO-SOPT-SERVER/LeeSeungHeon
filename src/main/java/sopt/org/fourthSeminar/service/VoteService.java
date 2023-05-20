package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSeminar.controller.dto.request.VoteRequestDto;
import sopt.org.fourthSeminar.domain.Vote;
import sopt.org.fourthSeminar.infrastructure.VoteRepository;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    @Transactional
    public void create(VoteRequestDto request) {
        StringBuilder voteList = new StringBuilder();

        for(int i = 0; i < request.getVoteList().size(); i++) {
            if (request.getVoteList().get(i)) {
                voteList.append(i + 1).append(" ");
            }
        }

        Vote newVote = Vote.newInstance(
                request.getName(),
                request.getPart(),
                voteList.toString()
        );

        voteRepository.save(newVote);
    }
}
