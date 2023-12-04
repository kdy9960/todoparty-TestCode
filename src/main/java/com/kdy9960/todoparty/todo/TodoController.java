package com.kdy9960.todoparty.todo;


import com.kdy9960.todoparty.CommonResponseDto;
import com.kdy9960.todoparty.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> postTodo(@RequestBody TodoRequestDto todoRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        TodoResponseDto responseDto = todoService.createPost(todoRequestDto, userDetails.getUser());

        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("")
    public ResponseEntity<Void> getTodoList() {
        return ResponseEntity.ok().build();
    }
}
