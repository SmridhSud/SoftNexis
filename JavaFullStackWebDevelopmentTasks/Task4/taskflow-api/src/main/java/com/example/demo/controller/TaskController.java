package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.TaskNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping
    public List<EntityModel<Task>> getAllTasks() {
        List<Task> tasks = repository.findAll();
        List<EntityModel<Task>> models = new ArrayList<>();
        for (Task task : tasks) {
            models.add(toModel(task));
        }
        return models;
    }

    @GetMapping("/{id}")
    public EntityModel<Task> getTaskById(@PathVariable Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return toModel(task);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Task>> createTask(@Valid @RequestBody Task task) {
        Task saved = repository.save(task);
        return new ResponseEntity<>(toModel(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public EntityModel<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setCompleted(taskDetails.isCompleted());
        return toModel(repository.save(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        repository.delete(task);
        return ResponseEntity.noContent().build();
    }

    private EntityModel<Task> toModel(Task task) {
        return EntityModel.of(task,
                linkTo(methodOn(TaskController.class).getTaskById(task.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).getAllTasks()).withRel("tasks"));
    }
}
