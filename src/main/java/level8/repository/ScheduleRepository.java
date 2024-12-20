package level8.repository;

import level8.entity.Member;
import level8.entity.Schedule;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Page<Schedule> findAll(Pageable pageable);
    List<Schedule> findByMember(Member member);
}
