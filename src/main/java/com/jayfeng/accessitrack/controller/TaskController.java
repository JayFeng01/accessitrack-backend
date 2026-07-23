package com.jayfeng.accessitrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayfeng.accessitrack.model.Task;
import com.jayfeng.accessitrack.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {


@Autowired
private TaskService taskService;

    public TaskController() {
    }

 @GetMapping
public List<Task> getAllTasks() {
    return taskService.getAllTasks();
}   

@GetMapping("/{id}")
public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
       return taskService.getTaskById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
} 

@PutMapping("/{id}")
public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
    Task updated = taskService.updateTask(id, task);
    if (updated == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    boolean deleted = taskService.deleteTask(id);
    if (deleted) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}

@PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
                                        
}
