package br.com.easytask.Easy.Task.controller;

import br.com.easytask.Easy.Task.model.Task;
import br.com.easytask.Easy.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private static final Logger logger = Logger.getLogger(TaskController.class.getName());

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        logger.info("Fetching all tasks");
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        logger.info("Fetching task with ID: " + id);
        Task task = taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        logger.info("Creating new task with title: " + task.getTitle());
        Task createdTask = taskService.createTask(task);
        logger.info("Task created with ID: " + createdTask.getId());
        return createdTask;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        logger.info("Updating task with ID: " + id);
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        logger.info("Deleting task with ID: " + id);
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
