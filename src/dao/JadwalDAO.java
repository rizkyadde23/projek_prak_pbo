package dao;

import config.Koneksi;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Jadwal;

public class JadwalDAO {

    private Connection conn;

    public JadwalDAO() {
        try {
            conn = Koneksi.getConnection();
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }
    }

    // INSERT DATA JADWAL
    public void insert(Jadwal jadwal) {
        try {
            String sql = """
                INSERT INTO jadwal (
                    id_kereta,
                    asal,
                    tujuan,
                    tanggal,
                    jam,
                    harga,
                    kursi_tersedia
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, jadwal.getIdKereta());
            ps.setString(2, jadwal.getAsal());
            ps.setString(3, jadwal.getTujuan());
            ps.setString(4, jadwal.getTanggal());
            ps.setString(5, jadwal.getJam());
            ps.setInt(6, jadwal.getHarga());
            ps.setInt(7, jadwal.getKursiTersedia());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // GET ALL DATA JADWAL
    public ArrayList<Jadwal> getAll() {
        ArrayList<Jadwal> list = new ArrayList<>();
        try {
            String sql = """
                SELECT
                    jadwal.*,
                    kereta.nama_kereta
                FROM jadwal
                JOIN kereta
                ON jadwal.id_kereta = kereta.id_kereta
                ORDER BY jadwal.id_jadwal DESC
                """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Jadwal jadwal = new Jadwal();
                jadwal.setIdJadwal(rs.getInt("id_jadwal"));
                jadwal.setIdKereta(rs.getInt("id_kereta"));
                jadwal.setNamaKereta(rs.getString("nama_kereta"));
                jadwal.setAsal(rs.getString("asal"));
                jadwal.setTujuan(rs.getString("tujuan"));
                jadwal.setTanggal(rs.getString("tanggal"));
                jadwal.setJam(rs.getString("jam"));
                jadwal.setHarga(rs.getInt("harga"));
                jadwal.setKursiTersedia(rs.getInt("kursi_tersedia"));
                list.add(jadwal);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // UPDATE DATA JADWAL
    public void update(Jadwal jadwal) {
        try {
            String sql = """
                UPDATE jadwal SET
                    id_kereta = ?,
                    asal = ?,
                    tujuan = ?,
                    tanggal = ?,
                    jam = ?,
                    harga = ?,
                    kursi_tersedia = ?
                WHERE id_jadwal = ?
                """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, jadwal.getIdKereta());
            ps.setString(2, jadwal.getAsal());
            ps.setString(3, jadwal.getTujuan());
            ps.setString(4, jadwal.getTanggal());
            ps.setString(5, jadwal.getJam());
            ps.setInt(6, jadwal.getHarga());
            ps.setInt(7, jadwal.getKursiTersedia());
            ps.setInt(8, jadwal.getIdJadwal());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // DELETE DATA JADWAL
    public void delete(int id) {
        try {
            String sql = """
                DELETE FROM jadwal
                WHERE id_jadwal = ?
                """;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
