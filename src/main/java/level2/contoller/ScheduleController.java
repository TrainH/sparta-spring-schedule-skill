package level2.contoller;


import level2.dto.SchedulePatchRequestDto;
import level2.dto.SchedulePostRequestDto;
import level2.dto.ScheduleResponseDto;
import level2.service.ScheduleService;
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
    public ResponseEntity<ScheduleResponseDto> post(@RequestBody SchedulePostRequestDto postScheduleRequestDto) {
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
    public ResponseEntity<ScheduleResponseDto> getById(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getById(id);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> pathById(@PathVariable Long id,
                                                        @RequestBody SchedulePatchRequestDto patchScheduleRequestDto) {
        scheduleService.patchById(
                                        id,
                                        patchScheduleRequestDto.getUserName(),
                                        patchScheduleRequestDto.getTodoTitle(),
                                        patchScheduleRequestDto.getTodoContent()
                                );
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}