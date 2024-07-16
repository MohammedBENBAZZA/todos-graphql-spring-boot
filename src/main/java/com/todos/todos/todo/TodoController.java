package com.todos.todos.todo;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @QueryMapping
    public List<Todo> findAllTodos(){
        return todoService.getAllTodos();
    }

    @QueryMapping
    public Optional<Todo> findTodoById(@Argument String id) {
        return todoService.getTodoById(id);
    }

    @MutationMapping
    public Todo createTodo(@Argument Todo todo) {
        return todoService.createTodo(todo);
    }

    @MutationMapping
    public Optional<Todo> updateTodo(@Argument String id, @Argument Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @MutationMapping
    public Boolean deleteTodo(@Argument String id) {
        return todoService.deleteTodo(id);
    }
}
