package level2.contoller;

import level2.dto.MemberSignUpRequestDto;
import level2.dto.MemberSignUpResponseDto;
import level2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                        requestDto.getEmail()
                );

        return ResponseEntity.ok(responseDto);
    }

}
