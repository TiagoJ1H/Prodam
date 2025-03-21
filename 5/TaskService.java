package com.example.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() { return repository.findAll(); }
    public Optional<Task> getTaskById(Long id) { return repository.findById(id); }
    public Task createTask(Task task) { return repository.save(task); }
    public Task updateTask(Long id, Task task) {
        return repository.findById(id).map(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setStatus(task.getStatus());
            return repository.save(existingTask);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }
    public void deleteTask(Long id) { repository.deleteById(id); }
}
