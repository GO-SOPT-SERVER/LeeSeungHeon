package sopt.org.fourthSeminar.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.fourthSeminar.domain.Emotion;

import java.util.List;
import java.util.Optional;

public interface EmotionRepository extends Repository<Emotion, Long> {

    // CREATE
    void save(Emotion emotion);

    // READ
    List<Emotion> findAll();
    Optional<Emotion> findById(Long id);

    // UPDATE

    // DELETE
}
