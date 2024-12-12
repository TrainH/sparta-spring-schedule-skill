package level1.dto;

import level1.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;

    private final String userName;

    private final String todoTitle;

    private final String todoContent;

    public ScheduleResponseDto(Long id, String userName,
                               String todoTitle, String todoContent) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
