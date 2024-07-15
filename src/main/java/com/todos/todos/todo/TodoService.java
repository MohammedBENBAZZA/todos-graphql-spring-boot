package com.todos.todos.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public Optional<Todo> updateTodo(String id, Todo todo){
        return todoRepository.findById(id).map(t -> {
            t.setTitle(todo.getTitle());
            t.setContent(todo.getContent());
            return todoRepository.save(t);
        });
    }

    public boolean deleteTodo(String id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
