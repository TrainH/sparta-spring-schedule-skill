package level1.dto;

import lombok.Getter;

@Getter
public class PatchScheduleRequestDto {
    private final Long id;
    private final String userName;
    private final String todoTitle;
    private final String todoContent;


    public PatchScheduleRequestDto(Long id, String userName, String todoTitle, String todoContent){
        this.id = id;
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
    }
}
