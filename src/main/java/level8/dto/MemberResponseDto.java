package level8.dto;

import level8.entity.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberResponseDto {
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;

    public MemberResponseDto() {
    }

    public MemberResponseDto(Long id, String userName, String email, LocalDateTime createdAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public static MemberResponseDto toDto(Member member) {
        return new MemberResponseDto(member.getId(),
                                           member.getUserName(),
                                           member.getEmail(),
                                            member.getCreatedAt());
    }
}
