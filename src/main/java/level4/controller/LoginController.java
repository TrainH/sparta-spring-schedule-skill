package level4.controller;
import jakarta.servlet.http.HttpServletRequest;
import level4.dto.LoginRequestDto;
import level4.dto.LoginResponseDto;
import level4.service.AuthService;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody LoginRequestDto requestDto,
            HttpServletResponse response) {

        System.out.println("response.toString()");
        System.out.println("(requestDto.getEmail()"+requestDto.getEmail());
        System.out.println(requestDto.getPassword());

        String sessionId = authService.authenticate(
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        if(sessionId != null) {
            Cookie cookie = new Cookie("SESSION", sessionId);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            cookie.setMaxAge(60*60); // 60분
            response.addCookie(cookie);
            System.out.println(cookie);
            return ResponseEntity.ok(new LoginResponseDto("Login succeessful"));
        }
        return ResponseEntity.status(401).body(new LoginResponseDto("잘못된  이메일과 패스워드"));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        System.out.println(response.toString());
        Cookie cookie = new Cookie("SESSION", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 로그아웃이면 쿠키는 바로 만료
        response.addCookie(cookie);
        return ResponseEntity.noContent().header("message", "Logout successful").build();
    }
}