package co.edu.udec.taskmgr.domain.entidades;

import co.edu.udec.taskmgr.domain.enums.UserRole;



public class User {
    private final String email;
    private final String password;
    private final String name;
    private final UserRole role;

    public User(String email, String password, String name, UserRole role) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be empty");
        if (password == null || password.length() < 6) throw new IllegalArgumentException("Password too short");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty");
        if (role == null) throw new IllegalArgumentException("Role cannot be null");

        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public UserRole getRole() { return role; }
}
