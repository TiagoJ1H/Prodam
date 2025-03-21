package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks() { return service.getAllTasks(); }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) { return service.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found")); }

    @PostMapping
    public Task createTask(@RequestBody Task task) { return service.createTask(task); }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) { return service.updateTask(id, task); }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) { service.deleteTask(id); }
}