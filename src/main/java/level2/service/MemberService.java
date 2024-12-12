package level2.service;

import level2.dto.MemberSignUpResponseDto;
import level2.entity.Member;
import level2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberSignUpResponseDto signUp(String userName, String email) {

        Member member = new Member(userName, email);

        Member savedMember = memberRepository.save(member);

        return new MemberSignUpResponseDto(savedMember.getId(), savedMember.getUserName(), savedMember.getEmail());
    }
}
