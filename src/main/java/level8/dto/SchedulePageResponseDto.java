package level8.dto;

import level8.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {
    private final Long id;

    private final String userName;

    private final String todoTitle;

    private final String todoContent;

    private final int numOfComments;

    private final LocalDateTime created;

    private final LocalDateTime modified;



    public SchedulePageResponseDto(Long id, String userName,
                               String todoTitle, String todoContent,
                               int numOfComments,
                               LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.numOfComments = numOfComments;
        this.created = created;
        this.modified = modified;
    }

    public static SchedulePageResponseDto toDto(Schedule schedule,
                                                int numOfComments) {
        return new SchedulePageResponseDto(schedule.getId(), schedule.getUserName(),
                schedule.getTodoTitle(), schedule.getTodoContent(),
                numOfComments,
                schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
