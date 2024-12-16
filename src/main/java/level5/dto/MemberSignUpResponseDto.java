package level5.dto;

import level5.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberSignUpResponseDto {
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;

    public MemberSignUpResponseDto() {
    }

    public MemberSignUpResponseDto(Long id, String userName, String email, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public static MemberSignUpResponseDto toDto(Member member) {
        return new MemberSignUpResponseDto(member.getId(),
                                           member.getUserName(),
                                           member.getEmail(),
                                            member.getCreatedAt());
    }
}
