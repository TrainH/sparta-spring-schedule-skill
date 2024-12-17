package level8.controller;


import level8.dto.SchedulePageResponseDto;
import level8.dto.SchedulePatchRequestDto;
import level8.dto.SchedulePostRequestDto;
import level8.dto.ScheduleResponseDto;
import level8.entity.Schedule;
import level8.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public Object post(
            @Validated @RequestBody SchedulePostRequestDto postScheduleRequestDto,
            BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                log.info("validation errors={}", bindingResult);
                return bindingResult.getAllErrors();
            }

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

    @GetMapping("/list")
    public ResponseEntity<Page<SchedulePageResponseDto>> getList(
            @RequestParam(value="page", defaultValue = "") int page
    ) {
        Page<SchedulePageResponseDto> scheduleList =
                scheduleService.getPageList(page);
        return ResponseEntity.ok(scheduleList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getById(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getById(id);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> pathById(
            @Validated
            @PathVariable Long id,
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