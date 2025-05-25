package co.edu.udec.taskmgr.presentation.controller;



import co.edu.udec.taskmgr.domain.enums.UserRole;
import co.edu.udec.taskmgr.domain.entidades.User;
import co.edu.udec.taskmgr.application.usecases.user.login.LoginUserQuery;
import co.edu.udec.taskmgr.application.usecases.user.forgotpassword.ForgotPasswordCommand;
import co.edu.udec.taskmgr.application.usecases.user.create.CreateUserCommand;
import co.edu.udec.taskmgr.application.usecases.user.create.ICreateUser;
import co.edu.udec.taskmgr.application.usecases.user.forgotpassword.IForgotPassword;
import co.edu.udec.taskmgr.application.usecases.user.login.ILoginUser;


public class UserController {
    private final ICreateUser createUserHandler;
    private final ILoginUser loginUserHandler;
    private final IForgotPassword forgotPasswordHandler;

    public UserController(ICreateUser createUserHandler,
                          ILoginUser loginUserHandler,
                          IForgotPassword forgotPasswordHandler) {
        this.createUserHandler = createUserHandler;
        this.loginUserHandler = loginUserHandler;
        this.forgotPasswordHandler = forgotPasswordHandler;
    }

    public void register(String email, String password, String name, String roleName) {
        var role = Enum.valueOf(UserRole.class, roleName.toUpperCase());
        createUserHandler.handle(new CreateUserCommand(email, password, name, role));
        System.out.println("Usuario registrado correctamente.");
    }

    public void login(String email, String password) {
        try {
            User user = loginUserHandler.handle(new LoginUserQuery(email, password));
            System.out.println("Bienvenido " + user.getName() + " [" + user.getRole() + "]");
        } catch (IllegalArgumentException e) {
            System.out.println("Error de autenticación: " + e.getMessage());
        }
    }

    public void forgotPassword(String email) {
        try {
            forgotPasswordHandler.handle(new ForgotPasswordCommand(email));
            System.out.println("Correo de recuperación enviado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
