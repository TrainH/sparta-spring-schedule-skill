package level1.service;

import level1.dto.ScheduleResponseDto;
import level1.entity.Schedule;
import level1.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto post(String userName, String todoTitle, String todoContent) {
        System.out.println(userName);
        System.out.println(todoTitle);
        System.out.println(todoContent);

        Schedule schedule = new Schedule(userName, todoTitle, todoContent);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),
                                       schedule.getUserName(),
                                       schedule.getTodoTitle(),
                                       schedule.getTodoContent());

    }
}
