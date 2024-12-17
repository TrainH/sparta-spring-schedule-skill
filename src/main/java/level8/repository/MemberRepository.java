package level8.repository;

import level8.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // 아래코드는 쿼리로 의미 SELECT * FROM member WHERE user_name = ?;

    Optional<Member> findByUserName(String userName);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByEmailAndPassword(String email, String password);
}
