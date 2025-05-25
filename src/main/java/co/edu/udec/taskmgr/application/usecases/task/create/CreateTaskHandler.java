package co.edu.udec.taskmgr.application.usecases.task.create;

import co.edu.udec.taskmgr.domain.puertos.ITaskRepository;



public class CreateTaskHandler implements ICreateTask {
    private final ITaskRepository repository;

    public CreateTaskHandler(ITaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CreateTaskCommand command) {
        repository.save(command.toTask());
    }
}
