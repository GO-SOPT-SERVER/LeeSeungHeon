package sopt.org.fourthSeminar.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Emotion extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String emotionContent;

    @Column(nullable = false)
    private LocalDate recordDate;

    @Column(nullable = false)
    private int positive;

    @Column(nullable = false)
    private int negative;

    @Column(nullable = false)
    private int neutral;

    @Column(nullable = false)
    private String analysis;

    @Column(nullable = false)
    private String emotionType;

    private Emotion(String emotionContent, LocalDate recordDate, int positive, int negative, int neutral, String analysis, String emotionType) {
        this.emotionContent = emotionContent;
        this.recordDate = recordDate;
        this.positive = positive;
        this.negative = negative;
        this.neutral = neutral;
        this.analysis = analysis;
        this.emotionType = emotionType;
    }

    public static Emotion newInstance(String emotionContent, LocalDate recordDate, int positive, int negative, int neutral, String analysis, String emotionType) {
        return new Emotion(emotionContent, recordDate, positive, negative, neutral, analysis, emotionType);
    }
}
