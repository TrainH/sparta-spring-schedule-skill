package level8.controller;

import level8.dto.CommentPatchRequestDto;
import level8.dto.CommentPostRequestDto;
import level8.dto.CommentResponseDto;
import level8.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 댓글 CRUD
@Slf4j
@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public Object post(
            @Validated @RequestBody CommentPostRequestDto postRequestDto,
            BindingResult bindingResult
            ) {
        if (bindingResult.hasErrors()){
            log.info("validation errors = {}", bindingResult);
            return bindingResult.getAllErrors();
        }
        CommentResponseDto commentResponseDto =
                                    commentService.post(
                                            postRequestDto.getSchedule_id(),
                                            postRequestDto.getComment()
                                    );

        return ResponseEntity.ok(commentResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getAll() {
        List<CommentResponseDto> commentResponseDtoList =
                commentService.getAll();
        return ResponseEntity.ok(commentResponseDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> getById(@PathVariable Long id) {
        CommentResponseDto commentResponseDto = commentService.getById(id);
        return ResponseEntity.ok(commentResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResponseDto> pathById(
            @Validated
            @PathVariable Long id,
            @RequestBody CommentPatchRequestDto patchRequestDto) {

        commentService.patchById(
                id,
                patchRequestDto.getComment()
        );
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        commentService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
