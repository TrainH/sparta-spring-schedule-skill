package level8.service;


import level8.dto.SchedulePageResponseDto;
import level8.dto.ScheduleResponseDto;
import level8.entity.Member;
import level8.entity.Schedule;
import level8.repository.MemberRepository;
import level8.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

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

    public Page<SchedulePageResponseDto> getPageList(int page){
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "modifiedAt"));

        return scheduleRepository.findAll(pageable)
                                 .map(schedule ->
                                         SchedulePageResponseDto.toDto(schedule, schedule.getComments().size()));
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

        if (userName != null) {
            foundSchedule.setUserName(userName);
        }

        if (todoTitle != null) {
            foundSchedule.setTodoTitle(todoTitle);
        }

        if (todoContent != null) {
            foundSchedule.setTodoContent(todoContent);
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
