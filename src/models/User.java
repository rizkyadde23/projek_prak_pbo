package models;

public class User {

    private int idUser;
    private String nama;
    private String username;
    private String password;
    private UserRole role;

    public User() {
    }

    public User(
            int idUser,
            String nama,
            String username,
            String password,
            UserRole role
    ) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {

        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong"
            );
        }

        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        if (username == null || username.length() < 4) {
            throw new IllegalArgumentException(
                    "Username minimal 4 karakter"
            );
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password == null || password.length() < 4) {
            throw new IllegalArgumentException(
                    "Password minimal 4 karakter"
            );
        }

        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
