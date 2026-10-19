package ru.arutyunovg4.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arutyunovg4.entity.Task;
import ru.arutyunovg4.entity.dto.TaskDto;
import ru.arutyunovg4.entity.dto.TasksContainerDto;
import ru.arutyunovg4.entity.dto.request.CreateTaskRequest;
import ru.arutyunovg4.entity.dto.request.UpdateTaskRequest;
import ru.arutyunovg4.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TasksContainerDto findAll() {
        List<TaskDto> tasks = taskRepository.findAll()
                .stream()
                .map(Task::toDto)
                .toList();
        return new TasksContainerDto(tasks);
    }

    public TaskDto create(CreateTaskRequest request) {
        return taskRepository.save(request.toEntity()).toDto();
    }

    public TaskDto updateTaskStatus(long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found " + id));
        task.setStatus(request.getStatus());

        return taskRepository.save(task).toDto();
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }
}
