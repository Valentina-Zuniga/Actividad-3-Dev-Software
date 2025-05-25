package co.edu.udec.taskmgr.application.usecases.task.all;

import co.edu.udec.taskmgr.domain.entidades.Task;
import co.edu.udec.taskmgr.domain.puertos.ITaskRepository;
import java.util.List;

public class ListTasksHandler implements IListTasks {
    private final ITaskRepository repository;

    public ListTasksHandler(ITaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> handle(ListTasksQuery query) {
        return repository.findByUserEmail(query.getUserEmail());
    }
}
