package sopt.org.fourthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.fourthSeminar.controller.dto.response.EmotionCalendarResponseDto;
import sopt.org.fourthSeminar.controller.dto.response.EmotionResponseDto;
import sopt.org.fourthSeminar.domain.Emotion;
import sopt.org.fourthSeminar.exception.Error;
import sopt.org.fourthSeminar.exception.model.ConflictException;
import sopt.org.fourthSeminar.exception.model.NotFoundException;
import sopt.org.fourthSeminar.infrastructure.EmotionRepository;
import sopt.org.fourthSeminar.service.dto.request.EmotionServiceDto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmotionService {

    private final EmotionRepository emotionRepository;

    @Transactional
    public void create(EmotionServiceDto request) {
        if (emotionRepository.existsByRecordDate(request.getRecordDate())) {
            throw new ConflictException(Error.ALREADY_EXIST_EMOTION_EXCEPTION, Error.ALREADY_EXIST_EMOTION_EXCEPTION.getMessage());
        }

        Emotion newEmotion = Emotion.newInstance(
                request.getEmotionContent(),
                request.getRecordDate(),
                request.getPositive(),
                request.getNegative(),
                request.getNeutral(),
                request.getAnalysis(),
                request.getEmotionType()
        );

        emotionRepository.save(newEmotion);
    }

    @Transactional
    public List<EmotionCalendarResponseDto> getCalendar(LocalDate date) {
        List<Emotion> emotions = emotionRepository.findByRecordDateBetween(date.withDayOfMonth(1), date.withDayOfMonth(date.lengthOfMonth()));

        return emotions.stream()
                .map(emotion -> EmotionCalendarResponseDto.of(emotion.getId(), emotion.getRecordDate(), emotion.getEmotionType()))
                .sorted(Comparator.comparing(EmotionCalendarResponseDto::getRecordDate))
                .collect(Collectors.toList());
    }

    @Transactional
    public EmotionResponseDto getOne(Long emotionId) {
        Emotion emotion = emotionRepository.findById(emotionId)
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_EMOTION_EXCEPTION, Error.NOT_FOUND_EMOTION_EXCEPTION.getMessage()));

        return EmotionResponseDto.of(
                emotion.getRecordDate(),
                emotion.getEmotionContent(),
                emotion.getPositive(),
                emotion.getNegative(),
                emotion.getNeutral(),
                emotion.getAnalysis(),
                emotion.getEmotionType()
        );
    }
}
