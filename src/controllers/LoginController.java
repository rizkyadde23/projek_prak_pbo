package controllers;

import config.Session;
import exceptions.LoginException;
import exceptions.RegisterException;
import models.Admin;
import models.AbstractUser;
import models.Customer;
import models.User;
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

    public AbstractUser login(
            String username,
            String password
    ) throws LoginException {

        User user
                = authService.login(
                        username,
                        password
                );

        Session.idUser
                = user.getIdUser();

        Session.nama
                = user.getNama();

        Session.role
                = user.getRole();

        if ("admin".equalsIgnoreCase(user.getRole())) {

            Admin admin = new Admin();
            admin.setNama(user.getNama());

            return admin;

        } else {

            Customer customer = new Customer();
            customer.setNama(user.getNama());

            return customer;
        }
    }

    public void register(
            String nama,
            String username,
            String password
    ) throws RegisterException {

        User user = new User();

        user.setNama(nama);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("user");

        registerService.register(user);
    }
}
