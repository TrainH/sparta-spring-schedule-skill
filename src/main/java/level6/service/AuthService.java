package level6.service;
import level6.config.PasswordEncoder;
import level6.entity.Member;
import level6.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final Map<String, String> sessionStorage = new HashMap<>();

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String authenticate(String email, String password) {

        String encodedPassword = passwordEncoder.encode(password);

        Member foundMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "이메일을 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다.");
        }

        String sessionId = UUID.randomUUID().toString();
        if (sessionId != null) {
            System.out.println(sessionId);
            sessionStorage.put(email, sessionId);
            return sessionId;
        }
        return null;
    }

    public boolean validateSession(String sessionId) {
        return sessionStorage.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}