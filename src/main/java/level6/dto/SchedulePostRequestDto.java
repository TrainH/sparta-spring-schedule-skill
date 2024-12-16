package level6.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SchedulePostRequestDto {
    @NotNull
    @Size(min = 4, max = 10, message = "userName must be 4~10 characters.")
    private final String userName;

    @NotNull
    @Size(max = 10, message = "todoTitle must be in 10 characters.")
    private final String todoTitle;

    @NotNull
    @Size(max = 100, message = "todoContent must be in 100 characters.")
    private final String todoContent;


    public SchedulePostRequestDto(String userName, String todoTitle, String todoContent){
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
