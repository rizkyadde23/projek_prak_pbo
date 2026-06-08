package services;

import exceptions.LoginException;
import models.User;
import repository.UserRepository;

public class AuthenticationService {

    private final UserRepository repository;

    public AuthenticationService(
            UserRepository repository
    ) {
        this.repository = repository;
    }

    public User login(
            String username,
            String password
    ) throws LoginException {

        if (username.isBlank()
                || password.isBlank()) {

            throw new LoginException(
                    "Username dan Password wajib diisi"
            );
        }

        User user
                = repository.login(
                        username,
                        password
                );

        if (user == null) {

            throw new LoginException(
                    "Username atau Password salah"
            );
        }

        return user;
    }
}
