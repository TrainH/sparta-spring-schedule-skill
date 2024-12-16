package level5.dto;

import level5.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;

    private final String userName;

    private final String todoTitle;

    private final String todoContent;

    private final LocalDateTime created;

    private final LocalDateTime modified;

    public ScheduleResponseDto(Long id, String userName,
                               String todoTitle, String todoContent,
                               LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.created = created;
        this.modified = modified;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserName(),
                                        schedule.getTodoTitle(), schedule.getTodoContent(),
                                        schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
