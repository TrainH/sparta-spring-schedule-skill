package level4.controller;

import level4.dto.MemberSignUpRequestDto;
import level4.dto.MemberSignUpResponseDto;
import level4.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<MemberSignUpResponseDto> signUp(@RequestBody MemberSignUpRequestDto requestDto) {

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
