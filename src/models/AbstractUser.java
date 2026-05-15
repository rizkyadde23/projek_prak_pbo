package models;

//Abstract Class
//Interface Implementation
public abstract class AbstractUser implements UserAccess {

    // Encapsulation
    protected String nama;
    protected String role;

    // Getter
    public String getNama() {
        return nama;
    }

    // Setter
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            this.nama = "Unknown";
        } else {
            this.nama = nama;
        }
    }

    // Getter
    public String getRole() {
        return role;
    }

    // Method Info
    public void loginInfo() {
        System.out.println("Login sebagai: " + role);
    }

    // Abstract Method
    public abstract void showRole();
}
