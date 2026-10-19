package ru.arutyunovg4.entity;

import jakarta.persistence.*;
import ru.arutyunovg4.entity.dto.TaskDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = true, length = 500)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    public Task() {
    }

    public Task(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
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

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public TaskDto toDto() {
        return new TaskDto(
                id,
                title,
                description,
                status,
                createdAt
                );
    }

}
