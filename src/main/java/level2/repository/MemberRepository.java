package level2.repository;

import level2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 아래코드는 쿼리로 의미 SELECT * FROM member WHERE user_name = ?;
    Optional<Member> findByUserName(String userName);
}
