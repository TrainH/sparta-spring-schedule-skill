package level8.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 유저(Member) Entity

@Setter
@Getter
@Entity
@Table(name = "member")
public class Member extends MemberBaseEntity {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    // 유저명
    @Column(nullable = false, unique = true)
    private String userName;

    // 이메일
    @Column(name="email", nullable = false, unique = true)
    private String email;

    // 비밀번호
    @Column(name = "password")
    private String password;

    public Member() {
    }

    public Member(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
