package level7.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CommentPostRequestDto {

    @NotNull
    private final Long schedule_id;

    @NotNull
    @Size(max = 200, message = "comment must be in 200 characters.")
    private final String comment;

    public CommentPostRequestDto(Long schedule_id, String comment) {
        this.schedule_id = schedule_id;
        this.comment = comment;
    }
}

