package level2.dto;

import lombok.Getter;

@Getter
public class MemberSignUpRequestDto {
    private final String userName;
    private final String email;
    public MemberSignUpRequestDto(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
