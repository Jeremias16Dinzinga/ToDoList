package com.sweet_company.ToDoList.controller;

import com.sweet_company.ToDoList.entity.ToDoEntity;
import com.sweet_company.ToDoList.services.ToDoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public List<ToDoEntity> create(@Valid @RequestBody ToDoEntity toDo){
        return this.toDoService.create(toDo);
    }
    @PutMapping
    public List<ToDoEntity> update(@Valid @RequestBody ToDoEntity toDo){
        return this.toDoService.update(toDo);
    }
    @DeleteMapping("/{id}")
    public List<ToDoEntity> delete(@PathVariable("id") Long id){
        return this.toDoService.delete(id);
    }
    @GetMapping
    public List<ToDoEntity> list(){
        return this.toDoService.list();
    }
}
