package level4.dto;

import lombok.Getter;

@Getter
public class SchedulePatchRequestDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContent;


    public SchedulePatchRequestDto(Long id, String userName, String todoTitle, String todoContent){
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
