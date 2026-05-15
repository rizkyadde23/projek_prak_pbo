package models;

// Inheritance
public class Customer extends AbstractUser {

    // Constructor
    public Customer() {
        this.role = "user";
    }

    // Overriding
    @Override
    public void aksesDashboard() {
        System.out.println("User membuka dashboard user");
    }

    // Overriding
    @Override
    public void menuAccess() {
        System.out.println("User dapat memesan tiket");
    }

    // Overriding
    @Override
    public void showRole() {
        System.out.println("Role: Customer");
    }
}
