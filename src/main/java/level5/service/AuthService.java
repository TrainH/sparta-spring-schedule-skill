package level5.service;

import level5.entity.Member;
import level5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final Map<String, String> sessionStorage = new HashMap<>();

    private final MemberRepository memberRepository;

    public String authenticate(String email, String password) {

        Member foundMember = memberRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "비밀번호가 틀렸습니다."));


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