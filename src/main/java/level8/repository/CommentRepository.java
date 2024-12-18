package level8.repository;

import level8.entity.Comment;
import level8.entity.Member;
import level8.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByScheduleId(Long scheduleId);
    List<Comment> findByMember(Member member);
    List<Comment> findBySchedule(Schedule schedule);
}