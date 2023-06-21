package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.SocialUser;

public interface SocialUserRepository extends Repository<SocialUser, Long> {

    // CREATE
    void save(SocialUser socialUser);
}
