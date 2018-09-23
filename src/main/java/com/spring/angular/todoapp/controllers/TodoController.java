package com.spring.angular.todoapp.controllers;

import com.spring.angular.todoapp.models.Todo;
import com.spring.angular.todoapp.repositories.TodoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TodoController {


    @Autowired
    TodoRepositories todoRepositories;


    @GetMapping("/todos")
    public List<Todo> getAllTodos() {

        Sort sortByCreatedAt = new Sort(Sort.Direction.DESC, "createdAt");
        return todoRepositories.findAll(sortByCreatedAt);
    }


    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo){
        todo.setCompleted(false);

        return todoRepositories.save(todo);
    }

    @GetMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> getTodoId(@PathVariable("id") String id){
        return todoRepositories.findById(id)
                .map(todo -> ResponseEntity.ok().body(todo))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping(value = "/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id, @Valid @RequestBody Todo todo){


        return todoRepositories.findById(id)
                .map(todoData -> {
                    todoData.setTitle(todo.getTitle());
                    todoData.setCompleted(todo.getCompleted());
                    Todo updateTodo = todoRepositories.save(todoData);

                    return ResponseEntity.ok().body(updateTodo);
                }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id){

        return todoRepositories.findById(id)
                .map(todo ->  {
                    todoRepositories.deleteById(id);
                    return ResponseEntity.ok().build();

                }).orElse(ResponseEntity.notFound().build());


    }
}
