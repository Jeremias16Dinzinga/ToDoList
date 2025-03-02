package com.sweet_company.ToDoList.repositories;

import com.sweet_company.ToDoList.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
}
