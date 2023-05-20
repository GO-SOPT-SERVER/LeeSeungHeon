package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.Vote;

public interface VoteRepository extends Repository<Vote, Long> {
    // CREATE
    void save(Vote vote);
}
