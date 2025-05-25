package co.edu.udec.taskmgr.application.usecases.user.create;

import co.edu.udec.taskmgr.domain.entidades.User;
import co.edu.udec.taskmgr.domain.enums.UserRole;

public class CreateUserCommand {
    private final String email;
    private final String password;
    private final String name;
    private final UserRole role;

    public CreateUserCommand(String email, String password, String name, UserRole role) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.length() < 6) throw new IllegalArgumentException("Password too short");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (role == null) throw new IllegalArgumentException("Role is required");
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User toUser() {
        return new User(email, password, name, role);
    }
}
