package models;

public class CustomerRole implements Role {

    @Override
    public String getRoleName() {
        return "user";
    }

    @Override
    public String getDashboardType() {
        return "USER";
    }

    @Override
    public void menuAccess() {

        System.out.println(
                "User dapat memesan tiket"
        );
    }
}
