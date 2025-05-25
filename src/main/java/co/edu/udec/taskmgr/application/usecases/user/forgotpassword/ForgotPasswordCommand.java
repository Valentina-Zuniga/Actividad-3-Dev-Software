package co.edu.udec.taskmgr.application.usecases.user.forgotpassword;
public class ForgotPasswordCommand {
    private final String email;

    public ForgotPasswordCommand(String email) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
