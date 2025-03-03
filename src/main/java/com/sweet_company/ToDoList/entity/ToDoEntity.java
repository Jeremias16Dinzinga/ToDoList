package com.sweet_company.ToDoList.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="toDos")
@Data
public class ToDoEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name field is required")
    private String name;
    @NotBlank(message = "Description field is required")
    private String description;
    private boolean done;
    private Integer priority;

    public ToDoEntity() {
    }

    public ToDoEntity(String name, String description, boolean done, Integer priority) {
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }

    public ToDoEntity(long id, String name, String description, boolean done, Integer priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public Integer getPriority() {
        return priority;
    }
}
