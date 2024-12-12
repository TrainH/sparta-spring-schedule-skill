package level1.dto;

import lombok.Getter;

@Getter
public class PostScheduleRequestDto {
    private final String userName;
    private final String todoTitle;
    private final String todoContent;


    public PostScheduleRequestDto(String userName, String todoTitle, String todoContent){
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
