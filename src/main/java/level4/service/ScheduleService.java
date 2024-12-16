package level4.service;


import level4.dto.ScheduleResponseDto;
import level4.entity.Member;
import level4.entity.Schedule;
import level4.repository.MemberRepository;
import level4.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final MemberRepository memberRepository;

    public ScheduleResponseDto post(String userName, String todoTitle, String todoContent) {

        // userName으로 DB 조회해서 foudMember을 불러옴
        Member foundMember = memberRepository.findByUserName(userName)
                                             .orElseThrow(() ->
                                                     new ResponseStatusException(HttpStatus.NOT_FOUND, userName + "존재하지 않습니다."));

        Schedule schedule = new Schedule(userName, todoTitle, todoContent);

        schedule.setMember(foundMember);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),
                                       schedule.getUserName(),
                                       schedule.getTodoTitle(),
                                       schedule.getTodoContent(),
                                       schedule.getCreatedAt(),
                                       schedule.getModifiedAt());

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
