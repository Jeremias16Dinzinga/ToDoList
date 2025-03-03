package com.sweet_company.ToDoList.config;

import com.sweet_company.ToDoList.entity.ToDoEntity;
import com.sweet_company.ToDoList.repositories.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSeeder {
    @Bean
    CommandLineRunner initDatabase(ToDoRepository repository) {
        return args -> {
            repository.save(new ToDoEntity("Tarefa 1", "Primeira tarefa", false, 1));
            repository.save(new ToDoEntity("Tarefa 2", "Segunda tarefa", true, 2));
        };
    }
}
