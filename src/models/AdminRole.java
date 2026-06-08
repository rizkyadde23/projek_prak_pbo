package models;

public class AdminRole implements Role {

    @Override
    public String getRoleName() {
        return "admin";
    }

    @Override
    public String getDashboardType() {
        return "ADMIN";
    }

    @Override
    public void menuAccess() {

        System.out.println(
                "Admin dapat CRUD data"
        );
    }
}
