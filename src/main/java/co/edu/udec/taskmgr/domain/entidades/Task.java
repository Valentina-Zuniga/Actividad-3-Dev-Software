package co.edu.udec.taskmgr.domain.entidades;

import co.edu.udec.taskmgr.domain.enums.TaskStatus;



public class Task {
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final String userEmail;

    public Task(String title, String description, TaskStatus status, String userEmail) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("Title is required");
        if (description == null) description = "";
        if (status == null) throw new IllegalArgumentException("Status is required");
        if (userEmail == null || userEmail.isBlank()) throw new IllegalArgumentException("User email is required");

        this.title = title;
        this.description = description;
        this.status = status;
        this.userEmail = userEmail;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public String getUserEmail() { return userEmail; }
}
