package level7.dto;

import level7.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CommentResponseDto {
    private final Long id;

    private final Long schedule_id;

    private final String comment;

    private final LocalDateTime created;

    private final LocalDateTime modified;

    public CommentResponseDto(Long id,Long schedule_id,
                              String comment, LocalDateTime created, LocalDateTime modified) {
        this.id = id;
        this.schedule_id = schedule_id;
        this.comment = comment;
        this.created = created;
        this.modified = modified;
    }
    public static CommentResponseDto toDto(Comment comment){
        return new CommentResponseDto(comment.getId(),
                                     comment.getSchedule().getId(),comment.getComment(),
                                     comment.getCreatedAt(), comment.getModifiedAt());
    }
}
