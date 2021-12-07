package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoListController {

    private final TodoRepository repository;

    public TodoListController(TodoRepository repo) {
        this.repository = repo;
    }

    @PostMapping("/api/todo")
    public void addTodo(@RequestBody TodoEntity newTodo) {
        this.repository.save(newTodo);
    }

    @GetMapping("/api/todo")
    public Iterable<TodoEntity> getTodoList() {
        return this.repository.findAll();
    }
}
