package level2.dto;

import lombok.Getter;

@Getter
public class MemberSignUpResponseDto {
    private Long id;
    private String userName;
    private String email;

    public MemberSignUpResponseDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
