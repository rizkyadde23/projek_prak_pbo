package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.User;
import models.UserRole;
import repository.UserRepository;

public class UserDAO implements UserRepository {

    private final Connection conn;

    public UserDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean checkUsername(String username) {

        try {

            String sql
                    = """
                    SELECT 1
                    FROM users
                    WHERE username=?
                    """;

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs
                    = ps.executeQuery();

            return rs.next();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public void register(User user) {

        try {

            String sql
                    = """
                    INSERT INTO users
                    (
                        nama,
                        username,
                        password,
                        role
                    )
                    VALUES
                    (
                        ?, ?, ?, ?
                    )
                    """;

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(
                    4,
                    user.getRole().name().toLowerCase()
            );

            ps.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(
            String username,
            String password
    ) {

        try {

            String sql
                    = """
                    SELECT *
                    FROM users
                    WHERE username=?
                    AND password=?
                    """;

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs
                    = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            User user
                    = new User();

            user.setIdUser(
                    rs.getInt("id_user")
            );

            user.setNama(
                    rs.getString("nama")
            );

            user.setUsername(
                    rs.getString("username")
            );

            user.setPassword(
                    rs.getString("password")
            );

            String roleDb
                    = rs.getString("role");

            user.setRole(
                    "admin".equalsIgnoreCase(roleDb)
                    ? UserRole.ADMIN
                    : UserRole.USER
            );

            return user;

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
