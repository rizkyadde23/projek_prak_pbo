package models;

public class Admin extends AbstractUser {

    public Admin() {
        this.role = "admin";
    }

    @Override
    public void showRole() {
        System.out.println("Role : Admin");
    }

    @Override
    public String getDashboardType() {
        return "ADMIN";
    }

    @Override
    public void menuAccess() {

        System.out.println(
                "Admin dapat mengelola data"
        );
    }
}
