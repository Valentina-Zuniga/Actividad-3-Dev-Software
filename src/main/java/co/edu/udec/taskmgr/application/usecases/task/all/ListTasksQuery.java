package co.edu.udec.taskmgr.application.usecases.task.all;

public class ListTasksQuery {
    private final String userEmail;

    public ListTasksQuery(String userEmail) {
        if (userEmail == null || userEmail.isBlank()) throw new IllegalArgumentException("User email is required");
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
