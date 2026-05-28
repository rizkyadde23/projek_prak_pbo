package dao;

import config.Koneksi;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Kereta;

public class KeretaDAO {

    Connection conn;

    public KeretaDAO() {
        try {
            this.conn = Koneksi.getConnection();
        } catch (DatabaseException ex) {
            System.getLogger(KeretaDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // Query INSERT
    public void insert(Kereta kereta) {
        try {
            String sql
                    = "INSERT INTO kereta "
                    + "(nama_kereta) "
                    + "VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kereta.getNamaKereta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Query SELECT
    public ArrayList<Kereta> getAll() {
        ArrayList<Kereta> list = new ArrayList<>();
        try {
            String sql
                    = "SELECT * FROM kereta";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Kereta kereta = new Kereta();
                kereta.setIdKereta(rs.getInt("id_kereta"));
                kereta.setNamaKereta(rs.getString("nama_kereta"));
                list.add(kereta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // Query UPDATE
    public void update(Kereta kereta) {
        try {
            String sql
                    = "UPDATE kereta SET "
                    + "nama_kereta=? "
                    + "WHERE id_kereta=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kereta.getNamaKereta());
            ps.setInt(2, kereta.getIdKereta());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Query DELETE
    public void delete(int id) {
        try {
            String sql
                    = "DELETE FROM kereta "
                    + "WHERE id_kereta=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
