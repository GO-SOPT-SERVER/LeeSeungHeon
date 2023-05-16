package sopt.org.fourthSeminar.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imgSrc;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String content;

    private Post(String imgSrc, String name, String date, String content) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.date = date;
        this.content = content;
    }

    public static Post newInstance(String imgSrc, String name, String date, String content)  {
        return new Post(imgSrc, name, date, content);
    }
}
