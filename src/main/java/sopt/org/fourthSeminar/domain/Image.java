package sopt.org.fourthSeminar.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Board board;

    @Column(nullable = false)
    private String imageUrl;

    private Image(Board board, String imageUrl) {
        this.board = board;
        this.imageUrl = imageUrl;
    }

    public static Image newInstance(Board board, String imageUrl) {
        return new Image(board, imageUrl);
    }
}
