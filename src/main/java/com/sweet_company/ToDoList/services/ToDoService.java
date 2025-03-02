package com.sweet_company.ToDoList.services;

import com.sweet_company.ToDoList.entity.ToDoEntity;
import com.sweet_company.ToDoList.repositories.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoEntity> create(ToDoEntity toDo){
        this.toDoRepository.save(toDo);
        return this.list();
    }
    public List<ToDoEntity> update(Long id){
        this.toDoRepository.save(this.getToDo(id));
        return this.list();
    }

    public List<ToDoEntity> list(){
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
       return this.toDoRepository.findAll(sort);
    }
    public List<ToDoEntity> remove(Long id){
        this.toDoRepository.delete(this.getToDo(id));
        return this.list();
    }
    public ToDoEntity getToDo(Long id){
        ToDoEntity toDo = this.toDoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task doesn't exist!"));
        return toDo;
    }
}
