package level8.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

// 일정(Schedule) Entity

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends ScheduleBaseEntity {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성 유저명
    @Column(nullable = false)
    private String userName;

    // 할일 제목
    @Column(nullable = false)
    private String todoTitle;

    // 할일 내용
    @Column
    private String todoContent;

    // 유저 고유 식별자
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 댓글 갯수 산정
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Schedule() {}

    public Schedule(String userName, String todoTitle, String todoContent) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }
    public void setTodoContent(String todoContent){
        this.todoContent = todoContent;
    }

    public void setMember(Member member) {this.member = member;}

}
