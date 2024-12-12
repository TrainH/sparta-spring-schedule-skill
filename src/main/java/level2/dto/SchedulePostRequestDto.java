package level2.dto;

import lombok.Getter;

@Getter
public class SchedulePostRequestDto {
    private final String userName;
    private final String todoTitle;
    private final String todoContent;


    public SchedulePostRequestDto(String userName, String todoTitle, String todoContent){
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
