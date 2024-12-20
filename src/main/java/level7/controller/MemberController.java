package level7.controller;

import level7.dto.MemberPatchRequestDto;
import level7.dto.MemberPostRequestDto;
import level7.dto.MemberResponseDto;
import level7.dto.SchedulePatchRequestDto;
import level7.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Object post(
            @Validated @RequestBody MemberPostRequestDto requestDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("validation errors={}", bindingResult);
            return bindingResult.getAllErrors();
        }

        MemberResponseDto responseDto =
                memberService.post(
                        requestDto.getUserName(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> getAll() {
        List<MemberResponseDto> responseDto =
                memberService.getAll();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getById(@PathVariable Long id) {
        MemberResponseDto responseDto =
                memberService.getById(id);
        return ResponseEntity.ok(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberResponseDto> patchById(
            @Validated
            @PathVariable Long id,
            @RequestBody MemberPatchRequestDto requestDto
    ) {
        memberService.patchById(
                id,
                requestDto.getUserName(),
                requestDto.getPassword()
        );

        return ResponseEntity.ok(null);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MemberResponseDto> deleteById(@PathVariable Long id) {
                memberService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
