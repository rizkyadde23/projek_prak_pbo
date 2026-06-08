package factory;

import models.Admin;
import models.Customer;
import models.Role;

public class RoleFactory {

    private RoleFactory() {
    }

    public static Role create(
            String role
    ) {

        return switch (role.toLowerCase()) {

            case "admin" ->
                new Admin();

            case "user" ->
                new Customer();

            default ->
                throw new IllegalArgumentException(
                        "Role tidak dikenali"
                );
        };
    }
}
