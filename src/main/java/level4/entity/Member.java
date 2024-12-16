package level4.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends MemberBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(name="email", nullable = false, unique = true)
    private String email;

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
