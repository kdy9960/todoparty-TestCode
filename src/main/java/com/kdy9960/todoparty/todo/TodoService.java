package com.kdy9960.todoparty.todo;

import com.kdy9960.todoparty.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDto createPost(TodoRequestDto dto, User user) {
        Todo todo = new Todo(dto);
        todo.setUser(user);

        todoRepository.save(todo);

        return new TodoResponseDto(todo);
    }
}
