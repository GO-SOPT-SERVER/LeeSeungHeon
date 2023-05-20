package sopt.org.fourthSeminar.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vote extends AuditingTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String part;

    @Column(nullable = false)
    private String voteList;

    private Vote(String name, String part, String voteList) {
        this.name = name;
        this.part = part;
        this.voteList = voteList;
    }

    public static Vote newInstance(String name, String part, String voteList) {
        return new Vote(name, part, voteList);
    }
}
