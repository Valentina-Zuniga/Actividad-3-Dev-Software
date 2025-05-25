package co.edu.udec.taskmgr.application.usecases.task.create;

import co.edu.udec.taskmgr.domain.entidades.Task;
import co.edu.udec.taskmgr.domain.enums.TaskStatus;


public class CreateTaskCommand {
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final String userEmail;

    public CreateTaskCommand(String title, String description, TaskStatus status, String userEmail) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is required");
        if (status == null) throw new IllegalArgumentException("Status is required");
        if (userEmail == null || userEmail.isBlank()) throw new IllegalArgumentException("User email is required");
        this.title = title;
        this.description = description == null ? "" : description;
        this.status = status;
        this.userEmail = userEmail;
    }

    public Task toTask() {
        return new Task(title, description, status, userEmail);
    }
}
