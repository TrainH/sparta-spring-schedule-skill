package level1.service;


import level1.dto.ScheduleResponseDto;
import level1.entity.Schedule;
import level1.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto post(String userName, String todoTitle, String todoContent) {

        Schedule schedule = new Schedule(userName, todoTitle, todoContent);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),
                                       schedule.getUserName(),
                                       schedule.getTodoTitle(),
                                       schedule.getTodoContent(),
                                       schedule.getCreated(),
                                       schedule.getModified());

    }

    public List<ScheduleResponseDto> getAll(){
        return scheduleRepository.findAll()
                                 .stream()
                                 .map(ScheduleResponseDto::toDto)
                                 .toList();
    }

    public ScheduleResponseDto getById(Long id) {
        return scheduleRepository.findById(id)
                                 .map(ScheduleResponseDto::toDto)
                                 .orElseThrow(() ->
                                         new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id));
    }
}
