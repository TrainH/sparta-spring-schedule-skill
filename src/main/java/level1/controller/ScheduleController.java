package level1.controller;


import level1.dto.PostScheduleRequestDto;
import level1.dto.ScheduleResponseDto;
import level1.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAll() {
        List<ScheduleResponseDto> scheduleResponseDtoList =
                            scheduleService.getAll();
        return ResponseEntity.ok(scheduleResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getById(@PathVariable long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getById(id);
        return ResponseEntity.ok(scheduleResponseDto);
    }
}