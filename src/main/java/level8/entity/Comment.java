package level8.entity;

import jakarta.persistence.*;
import lombok.Getter;

// 댓글(Comment) Entity

@Getter
@Entity
@Table(name = "comment")
public class Comment extends CommentBaseEntity {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 내용
    @Column(nullable = false)
    private String comment;

    // 일정 고유 식별자
    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false)
    private Schedule schedule;

    // 유저 고유 식별자
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member member;


    public Comment() {}

    public Comment(String comment) {
        this.comment = comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

}