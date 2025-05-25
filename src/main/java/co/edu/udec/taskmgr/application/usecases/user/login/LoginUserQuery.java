package co.edu.udec.taskmgr.application.usecases.user.login;

public class LoginUserQuery {
    private final String email;
    private final String password;

    public LoginUserQuery(String email, String password) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
