package ru.arutyunovg4.entity.dto.request;

import ru.arutyunovg4.entity.Task;
import ru.arutyunovg4.entity.TaskStatus;


public class CreateTaskRequest {
    private final String title;
    private final String description;

    public CreateTaskRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public Task toEntity(){
        return new Task(
                title,
                description,
                TaskStatus.TODO
        );
    }
}
