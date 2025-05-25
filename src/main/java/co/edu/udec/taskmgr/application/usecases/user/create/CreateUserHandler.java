package co.edu.udec.taskmgr.application.usecases.user.create;

import co.edu.udec.taskmgr.domain.puertos.IUserRepository;

public class CreateUserHandler implements ICreateUser {
    private final IUserRepository repository;

    public CreateUserHandler(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CreateUserCommand command) {
        repository.save(command.toUser());
    }
}
