package level7.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberPatchRequestDto {
    @NotNull
    @Size(min = 4, max = 10, message = "userName must be 4~10 characters.")
    private final String userName;

    private final String password;

    public MemberPatchRequestDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
