package dao;

import config.Koneksi;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.User;

public class UserDAO {

    Connection conn;

    public UserDAO() {
        try {
            this.conn = Koneksi.getConnection();
        } catch (DatabaseException ex) {
            System.getLogger(UserDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    //Method Validasi Username
    public boolean checkUsername(String username) {
        boolean exists = false;
        try {
            String sql
                    = "SELECT * FROM users "
                    + "WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exists;
    }

    //Query INSERT
    public void register(User user) {
        try {
            String sql
                    = "INSERT INTO users "
                    + "(nama, username, password, role) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, "user");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Method Login
    public User login(String username, String password) {
        User user = null;
        try {
            String sql
                    = "SELECT * FROM users "
                    + "WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setIdUser(rs.getInt("id_user"));
                user.setNama(rs.getString("nama"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
