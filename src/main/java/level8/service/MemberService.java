package level8.service;

import level8.config.PasswordEncoder;
import level8.dto.MemberResponseDto;
import level8.entity.Member;
import level8.entity.Schedule;
import level8.entity.Comment;
import level8.repository.CommentRepository;
import level8.repository.MemberRepository;
import level8.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    private final PasswordEncoder passwordEncoder;


    public MemberResponseDto post(String userName, String email, String password) {
        String encodedPassword = passwordEncoder.encode(password);

        System.out.println(encodedPassword);

        Member member = new Member(userName, email, encodedPassword);

        Member savedMember = memberRepository.save(member);

        return new MemberResponseDto(savedMember.getId(),
                                            savedMember.getUserName(),
                                            savedMember.getEmail(),
                                            savedMember.getCreatedAt()
                                           );
    }


    public List<MemberResponseDto> getAll() {
        List<MemberResponseDto> members = memberRepository.findAll()
                                               .stream()
                                               .map(MemberResponseDto::toDto)
                                               .toList();

        return members;
    }


    public MemberResponseDto getById(Long id) {
        Member foundMember = memberRepository.findById(id)
                                             .orElseThrow(()->
                                                     new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                             id + "는 존재하지 않습니다. "));
        return MemberResponseDto.toDto(foundMember);
    }


    public void patchById(Long id, String userName, String password){
        Member foundMember = memberRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                id + "는 존재하지 않습니다."));

        if (userName != null) {
            foundMember.setUserName(userName);
        }

        if (password != null) {
            foundMember.setPassword(password);
        }

        memberRepository.save(foundMember);
    }


    public void deleteById(Long id) {
        Member foundMember = memberRepository.findById(id)
                                             .orElseThrow(()->
                                                     new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                             id + "는 존재하지 않습니다."));

        List<Schedule> schedules = scheduleRepository.findByMember(foundMember);

        scheduleRepository.deleteAll(schedules);

        List<Comment> comments = commentRepository.findByMember(foundMember);

        commentRepository.deleteAll(comments);

        memberRepository.delete(foundMember);
    }
}
