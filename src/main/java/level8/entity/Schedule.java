package level8.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends ScheduleBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String todoTitle;

    @Column
    private String todoContent;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

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
