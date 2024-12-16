package level3.dto;

import lombok.Getter;

@Getter
public class MemberSignUpRequestDto {
    private final String userName;
    private final String email;
    private final String password;
    public MemberSignUpRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
