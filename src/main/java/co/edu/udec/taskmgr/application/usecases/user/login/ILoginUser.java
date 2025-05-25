package co.edu.udec.taskmgr.application.usecases.user.login;

import co.edu.udec.taskmgr.domain.entidades.User;

public interface ILoginUser {
    User handle(LoginUserQuery query);
}
