package level1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String todoTitle;

    @Column
    private String todoContent;

    public Schedule() {}

    public Schedule(String userName, String todoTitle, String todoContent) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
