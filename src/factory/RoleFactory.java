package factory;

import models.Admin;
import models.Customer;
import models.Role;
import models.UserRole;

public class RoleFactory {

    private RoleFactory() {
    }

    public static Role create(
            UserRole role
    ) {

        return switch (role) {

            case ADMIN ->
                new Admin();

            case USER ->
                new Customer();
        };
    }
}
