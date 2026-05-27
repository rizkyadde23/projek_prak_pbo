package models;

import view.admin.DashboardAdmin;

// Inheritance
public class Admin extends AbstractUser {

    // Constructor
    public Admin() {
        this.role = "admin";
    }

    // Overriding
    @Override
    public void aksesDashboard() {
        new DashboardAdmin().setVisible(true);
        System.out.println("Admin membuka dashboard admin");
    }

    // Overriding
    @Override
    public void menuAccess() {
        System.out.println("Admin dapat CRUD data");
    }

    // Overriding
    @Override
    public void showRole() {
        System.out.println("Role: Admin");
    }
}
