package ru.arutyunovg4.entity.dto;

import ru.arutyunovg4.entity.TaskStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDto {

    private final long id;
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final LocalDateTime createdAt;

    public TaskDto(long id, String title, String description, TaskStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
