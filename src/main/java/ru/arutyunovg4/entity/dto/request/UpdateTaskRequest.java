package ru.arutyunovg4.entity.dto.request;


import ru.arutyunovg4.entity.TaskStatus;

public class UpdateTaskRequest {
    private final TaskStatus status;

    public UpdateTaskRequest(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

}
