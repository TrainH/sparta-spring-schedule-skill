package level8.service;

import level8.dto.CommentResponseDto;
import level8.entity.Comment;
import level8.entity.Schedule;
import level8.repository.CommentRepository;
import level8.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;


    public CommentResponseDto post(Long scheduleId, String comment){
        Schedule foundSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()
                        -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "scheduleId: " + scheduleId + "는 존재하지 않습니다."));

        Comment comment_ = new Comment(comment);
        comment_.setMember(foundSchedule.getMember());
        comment_.setSchedule(foundSchedule);
        commentRepository.save(comment_);
        return CommentResponseDto.toDto(comment_);
    }


    public List<CommentResponseDto> getAll(){
        return commentRepository.findAll()
                                .stream()
                                .map(CommentResponseDto::toDto)
                                .toList();
    }


    public CommentResponseDto getById(Long id){
        return commentRepository.findById(id)
                .map(CommentResponseDto::toDto)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id));
    }


    public void patchById(Long id, String comment){
        Comment foundComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id));

        if (comment != null) {
            foundComment.setComment(comment);
        }

        commentRepository.save(foundComment);
    }


    public void deleteById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않습니다. id = " + id);
        }
        commentRepository.deleteById(id);
    }
}
