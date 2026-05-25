package models;

public class User extends AbstractUser {

    // Encapsulation
    private int idUser;
    private String username;
    private String password;

    // Constructor
    public User() {

    }

    // Polymorphism Constructor
    public User(int idUser, String nama, String username, String password, String role) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter
    public int getIdUser() {
        return idUser;
    }

    // Setter
    public void setIdUser(int idUser) {
        if (idUser < 0) {
            this.idUser = 0;
        } else {
            this.idUser = idUser;
        }
    }

    // Getter
    @Override
    public String getNama() {
        return nama;
    }

    // Setter
    @Override
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            this.nama = "Unknown";
        } else {
            this.nama = nama;
        }
    }

    // Getter
    public String getUsername() {
        return username;
    }

    // Setter
    public void setUsername(String username) {
        if (username == null || username.length() < 4) {
            this.username = "guest";
        } else {
            this.username = username;
        }
    }

    // Getter
    public String getPassword() {
        return password;
    }

    // Setter
    public void setPassword(String password) {
        if (password == null || password.length() < 4) {
            this.password = "1234";
        } else {
            this.password = password;
        }
    }

    // Getter
    @Override
    public String getRole() {
        return role;
    }

    // Setter
    public void setRole(String role) {
        if (role == null || role.isEmpty()) {
            this.role = "user";
        } else {
            this.role = role;
        }
    }

    @Override
    public void aksesDashboard() {
        System.out.println("User membuka dashboard User");
    }

    // Overriding
    @Override
    public void menuAccess() {
        System.out.println("User dapat Memesan Tiket");
    }

    // Overriding
    @Override
    public void showRole() {
        System.out.println("Role: User");
    }
}
