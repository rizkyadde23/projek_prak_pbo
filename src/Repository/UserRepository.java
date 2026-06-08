package repository;

import models.User;

public interface UserRepository {

    boolean checkUsername(
            String username
    );

    void register(
            User user
    );

    User login(
            String username,
            String password
    );
}
