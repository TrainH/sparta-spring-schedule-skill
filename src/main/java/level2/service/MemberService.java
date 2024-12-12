package level2.service;

import level2.dto.MemberSignUpResponseDto;
import level2.entity.Member;
import level2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSignUpResponseDto signUp(String userName, String email) {

        Member member = new Member(userName, email);

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
