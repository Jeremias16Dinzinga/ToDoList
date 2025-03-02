package com.sweet_company.ToDoList.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="toDos")
@Data
public class ToDoEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private boolean done;
    private Integer priority;

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
