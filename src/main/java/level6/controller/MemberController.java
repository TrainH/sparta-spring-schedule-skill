package level6.controller;

import level6.dto.MemberSignUpRequestDto;
import level6.dto.MemberSignUpResponseDto;
import level6.service.MemberService;
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
    public Object signUp(
            @Validated @RequestBody MemberSignUpRequestDto requestDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.info("validation errors={}", bindingResult);
            return bindingResult.getAllErrors();
        }

        MemberSignUpResponseDto responseDto =
                memberService.signUp(
                        requestDto.getUserName(),
                        requestDto.getEmail(),
                        requestDto.getPassword()
                );

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<MemberSignUpResponseDto>> getAll() {
        List<MemberSignUpResponseDto> responseDto =
                memberService.getAll();
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberSignUpResponseDto> getById(@PathVariable Long id) {
        MemberSignUpResponseDto responseDto =
                memberService.getById(id);
        return ResponseEntity.ok(responseDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MemberSignUpResponseDto> deleteById(@PathVariable Long id) {
                memberService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
