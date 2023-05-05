package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends Repository<Post, Long> {
    List<Post> findAll();

    Optional<Post> findById(Long id);
}
