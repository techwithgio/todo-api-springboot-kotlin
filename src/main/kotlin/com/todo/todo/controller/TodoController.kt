package com.todo.todo.controller

import com.todo.todo.models.Todo
import com.todo.todo.services.TodoService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class TodoController {

    @Autowired
    lateinit var todoService: TodoService


    @PostMapping("/todo")
    fun saveTodo(@Valid @RequestBody todo: Todo) : Todo {
        return todoService.saveTodo(todo)
    }

    @GetMapping("/todo")
    fun allTodo() : List<Todo>? {
        return todoService.retrieveAllTodo();
    }

    @PutMapping("/todo/{id}")
    fun updateTodo(
        @PathVariable("id") todoId : Long,
        @Valid @RequestBody todo: Todo
    ) : Todo{
        return todoService.updateTodo(todo, todoId);
    }

    @DeleteMapping("/todo/{id}")
    fun deleteTodoById(
        @PathVariable("id") todoId : Long
    ) : ResponseEntity<Map<String, String>> {
        return todoService.deleteTodoById(todoId)
    }

}