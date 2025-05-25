package co.edu.udec.taskmgr.application.usecases.user.forgotpassword;

import co.edu.udec.taskmgr.domain.puertos.IEmailService;
import co.edu.udec.taskmgr.domain.puertos.IUserRepository;

public class ForgotPasswordHandler implements IForgotPassword {
    private final IUserRepository repository;
    private final IEmailService emailService;

    public ForgotPasswordHandler(IUserRepository repository, IEmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Override
    public void handle(ForgotPasswordCommand command) {
        var user = repository.findByEmail(command.getEmail());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        emailService.sendEmail(user.getEmail(), "Password Reset", "This is your reset email.");
    }
}
