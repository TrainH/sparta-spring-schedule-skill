package level7.repository;

import level7.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByScheduleId(Long scheduleId);
}