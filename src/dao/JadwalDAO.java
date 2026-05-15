package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Jadwal;

public class JadwalDAO {

    // Instansiasi Koneksi Database
    Connection conn = Koneksi.getConnection();

    // Query INSERT
    public void insert(Jadwal jadwal) {
        try {
            String sql
                    = "INSERT INTO jadwal "
                    + "(id_kereta, tanggal, jam, harga, kursi_tersedia) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps
                    = conn.prepareStatement(sql);
            ps.setInt(1, jadwal.getIdKereta());
            ps.setString(2, jadwal.getTanggal());
            ps.setString(3, jadwal.getJam());
            ps.setInt(4, jadwal.getHarga());
            ps.setInt(5, jadwal.getKursiTersedia());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Query SELECT
    public ArrayList<Jadwal> getAll() {
        ArrayList<Jadwal> list = new ArrayList<>();
        try {
            String sql
                    = "SELECT jadwal.*, kereta.nama_kereta "
                    + "FROM jadwal "
                    + "JOIN kereta "
                    + "ON jadwal.id_kereta = kereta.id_kereta";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jadwal jadwal = new Jadwal();
                jadwal.setIdJadwal(rs.getInt("id_jadwal"));
                jadwal.setIdKereta(rs.getInt("id_kereta"));
                jadwal.setNamaKereta(rs.getString("nama_kereta"));
                jadwal.setTanggal(rs.getString("tanggal"));
                jadwal.setJam(rs.getString("jam"));
                jadwal.setHarga(rs.getInt("harga"));
                jadwal.setKursiTersedia(rs.getInt("kursi_tersedia"));
                list.add(jadwal);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // Query UPDATE
    public void update(Jadwal jadwal) {
        try {
            String sql
                    = "UPDATE jadwal SET "
                    + "id_kereta=?, "
                    + "tanggal=?, "
                    + "jam=?, "
                    + "harga=?, "
                    + "kursi_tersedia=? "
                    + "WHERE id_jadwal=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, jadwal.getIdKereta());
            ps.setString(2, jadwal.getTanggal());
            ps.setString(3, jadwal.getJam());
            ps.setDouble(4, jadwal.getHarga());
            ps.setInt(5, jadwal.getKursiTersedia());
            ps.setInt(6, jadwal.getIdJadwal());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Query DELETE
    public void delete(int id) {
        try {
            String sql
                    = "DELETE FROM jadwal "
                    + "WHERE id_jadwal=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
