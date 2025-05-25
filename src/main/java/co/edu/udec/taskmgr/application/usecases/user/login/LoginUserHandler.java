package co.edu.udec.taskmgr.application.usecases.user.login;

import co.edu.udec.taskmgr.domain.entidades.User;
import co.edu.udec.taskmgr.domain.puertos.IUserRepository;

public class LoginUserHandler implements ILoginUser {
    private final IUserRepository repository;

    public LoginUserHandler(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User handle(LoginUserQuery query) {
        User user = repository.findByEmail(query.getEmail());
        if (user == null || !user.getPassword().equals(query.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        return user;
    }
}
