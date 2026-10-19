package ru.arutyunovg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.arutyunovg4.entity.dto.TaskDto;
import ru.arutyunovg4.entity.dto.TasksContainerDto;
import ru.arutyunovg4.entity.dto.request.CreateTaskRequest;
import ru.arutyunovg4.entity.dto.request.UpdateTaskRequest;
import ru.arutyunovg4.service.TaskService;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public TasksContainerDto findAll() {
        return taskService.findAll();
    }

    @PostMapping
    public TaskDto createTask(@RequestBody CreateTaskRequest request) {
        return taskService.create(request);
    }

    @PutMapping("/{id}")
    public TaskDto updateTaskStatus(@PathVariable long id, @RequestBody UpdateTaskRequest request) {
        return taskService.updateTaskStatus(id, request);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        taskService.delete(id);
    }

}
