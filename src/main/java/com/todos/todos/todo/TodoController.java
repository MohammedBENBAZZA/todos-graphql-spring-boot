package com.todos.todos.todo;

import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @MutationMapping
    public Todo createTodo(@Argument Todo todo) {
        return todoService.createTodo(todo);
    }

    @QueryMapping
    public List<Todo> findAllTodos(){
        return todoService.findAllTodos();
    }
}
