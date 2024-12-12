package level1.controller;


import level1.dto.PostScheduleRequestDto;
import level1.dto.ScheduleResponseDto;
import level1.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> post(@RequestBody PostScheduleRequestDto postScheduleRequestDto) {
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.post(
                        postScheduleRequestDto.getUserName(),
                        postScheduleRequestDto.getTodoTitle(),
                        postScheduleRequestDto.getTodoContent()
                );
        return ResponseEntity.ok(scheduleResponseDto);
    }

}