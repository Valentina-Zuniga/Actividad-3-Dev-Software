package co.edu.udec.taskmgr.presentation.controller;



import co.edu.udec.taskmgr.application.usecases.task.all.IListTasks;
import co.edu.udec.taskmgr.domain.enums.TaskStatus;
import co.edu.udec.taskmgr.domain.entidades.Task;
import co.edu.udec.taskmgr.application.usecases.task.all.ListTasksQuery;
import co.edu.udec.taskmgr.application.usecases.task.create.CreateTaskCommand;


import java.util.List;
import co.edu.udec.taskmgr.application.usecases.task.create.ICreateTask;

public class TaskController {
    private final ICreateTask createTaskHandler;
    private final IListTasks listTasksHandler;

    public TaskController(ICreateTask createTaskHandler, IListTasks listTasksHandler) {
        this.createTaskHandler = createTaskHandler;
        this.listTasksHandler = listTasksHandler;
    }

    public void createTask(String title, String description, String statusName, String userEmail) {
        var status = Enum.valueOf(TaskStatus.class, statusName.toUpperCase());
        createTaskHandler.handle(new CreateTaskCommand(title, description, status, userEmail));
        System.out.println("Tarea registrada exitosamente.");
    }

    public void listTasks(String userEmail) {
        List<Task> tasks = listTasksHandler.handle(new ListTasksQuery(userEmail));
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            tasks.forEach(t -> System.out.println(
                "[" + t.getStatus() + "] " + t.getTitle() + ": " + t.getDescription()
            ));
        }
    }
}
