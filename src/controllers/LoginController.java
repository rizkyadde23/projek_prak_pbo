package controllers;

import config.Session;
import exceptions.LoginException;
import exceptions.RegisterException;
import factory.RoleFactory;
import models.Role;
import models.User;
import models.UserRole;
import services.AuthenticationService;
import services.RegistrationService;

public class LoginController {

    private final AuthenticationService authService;
    private final RegistrationService registerService;

    public LoginController(
            AuthenticationService authService,
            RegistrationService registerService
    ) {
        this.authService = authService;
        this.registerService = registerService;
    }

    public Role login(
            String username,
            String password
    ) throws LoginException {

        User user
                = authService.login(
                        username,
                        password
                );

        Session.login(user);

        return RoleFactory.create(
                user.getRole()
        );
    }

    public void register(
            String nama,
            String username,
            String password
    ) throws RegisterException {

        User user
                = new User();

        user.setNama(nama);
        user.setUsername(username);
        user.setPassword(password);

        user.setRole(
                UserRole.USER
        );

        registerService.register(user);
    }
}
