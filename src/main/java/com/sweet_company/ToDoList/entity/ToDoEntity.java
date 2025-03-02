package com.sweet_company.ToDoList.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="toDos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private String description;
    private boolean done;
    private Integer priority;
}
