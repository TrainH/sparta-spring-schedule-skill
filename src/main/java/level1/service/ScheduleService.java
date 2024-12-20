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


    public void patchById(Long id, String userName, String todoTitle, String todoContent){
        Schedule foundSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id));
        System.out.println(userName);
        System.out.println(todoTitle);
        System.out.println(todoContent);

        System.out.println(foundSchedule.getUserName());
        System.out.println(foundSchedule.getTodoTitle());
        System.out.println(foundSchedule.getTodoContent());

        if (userName != null) {
            foundSchedule.setUserName(userName);
            System.out.println(foundSchedule.getUserName());
        }

        if (todoTitle != null) {
            foundSchedule.setTodoTitle(todoTitle);
            System.out.println(foundSchedule.getTodoTitle());
        }

        if (todoContent != null) {
            foundSchedule.setTodoContent(todoContent);
            System.out.println(foundSchedule.getTodoContent());
        }

        scheduleRepository.save(foundSchedule);
    }


    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id);
        }
        scheduleRepository.deleteById(id);
    }
}
