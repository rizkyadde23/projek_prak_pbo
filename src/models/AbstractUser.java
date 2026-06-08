package models;

public abstract class AbstractUser implements Role {

    protected String nama;
    protected String role;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {

        if (nama == null || nama.trim().isEmpty()) {
            this.nama = "Unknown";
        } else {
            this.nama = nama;
        }
    }

    public String getRole() {
        return role;
    }

    public void loginInfo() {
        System.out.println(
                "Login sebagai : " + role
        );
    }

    @Override
    public String getRoleName() {
        return role;
    }

    public abstract void showRole();

    @Override
    public abstract String getDashboardType();

    @Override
    public abstract void menuAccess();
}
