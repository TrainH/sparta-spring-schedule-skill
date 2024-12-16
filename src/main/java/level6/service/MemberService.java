package level6.service;

import level6.config.PasswordEncoder;
import level6.dto.MemberSignUpResponseDto;
import level6.entity.Member;
import level6.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberSignUpResponseDto signUp(String userName, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println(encodedPassword);

        Member member = new Member(userName, email, encodedPassword);

        Member savedMember = memberRepository.save(member);

        return new MemberSignUpResponseDto(savedMember.getId(),
                                            savedMember.getUserName(),
                                            savedMember.getEmail(),
                                            savedMember.getCreatedAt()
                                           );
    }

    public List<MemberSignUpResponseDto> getAll() {
        List<MemberSignUpResponseDto> members = memberRepository.findAll()
                                               .stream()
                                               .map(MemberSignUpResponseDto::toDto)
                                               .toList();

        return members;
    }

    public MemberSignUpResponseDto getById(Long id) {
        Member foundMember = memberRepository.findById(id)
                                             .orElseThrow(()->
                                                     new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                             id + "는 존재하지 않습니다. "));
        return MemberSignUpResponseDto.toDto(foundMember);
    }

    public void deleteById(Long id) {
        Member foundMember = memberRepository.findById(id)
                                             .orElseThrow(()->
                                                     new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                             id + "는 존재하지 않습니다."));

        memberRepository.delete(foundMember);
    }
}
