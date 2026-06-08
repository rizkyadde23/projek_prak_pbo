package services;

import exceptions.RegisterException;
import models.User;
import repository.UserRepository;

public class RegistrationService {

    private final UserRepository repository;

    public RegistrationService(
            UserRepository repository
    ) {
        this.repository = repository;
    }

    public void register(
            User user
    ) throws RegisterException {

        if (repository.checkUsername(
                user.getUsername()
        )) {

            throw new RegisterException(
                    "Username sudah digunakan"
            );
        }

        repository.register(user);
    }
}
