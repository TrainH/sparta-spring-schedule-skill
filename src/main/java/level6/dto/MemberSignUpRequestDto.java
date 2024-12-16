package level6.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class MemberSignUpRequestDto {
    @NotNull
    @Size(min = 4, max = 10, message = "userName must be 4~10 characters.")
    private final String userName;

    @NotNull
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Email should be in a valid format (e.g., user@example.com)."
    )

    private final String email;

    private final String password;

    public MemberSignUpRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
