package dao;

import config.Koneksi;
import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import models.Pemesanan;

public class PemesananDAO {

    Connection conn;

    public PemesananDAO() {
        try {
            this.conn = Koneksi.getConnection();
        } catch (DatabaseException ex) {
            System.getLogger(PemesananDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // Query SELECT
    public ArrayList<Pemesanan> getRiwayat(int idUser) {
        ArrayList<Pemesanan> list = new ArrayList<>();
        try {
            String sql
                    = "SELECT "
                    + "pemesanan.*, "
                    + "jadwal.tanggal, "
                    + "jadwal.jam, "
                    + "kereta.* "
                    + "FROM pemesanan "
                    + "JOIN jadwal "
                    + "ON pemesanan.id_jadwal = jadwal.id_jadwal "
                    + "JOIN kereta "
                    + "ON jadwal.id_kereta = kereta.id_kereta "
                    + "WHERE pemesanan.id_user=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pemesanan p = new Pemesanan();
                p.setIdPemesanan(rs.getInt("id_pemesanan"));
                p.setNamaKereta(rs.getString("nama_kereta"));
                p.setAsal(rs.getString("asal"));
                p.setTujuan(rs.getString("tujuan"));
                p.setTanggal(rs.getString("tanggal"));
                p.setJam(rs.getString("jam"));
                p.setJumlahTiket(rs.getInt("jumlah_tiket"));
                p.setTotalHarga(rs.getInt("total_harga"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // Query INSERT
    public void insert(Pemesanan p) {
        try {
            String sql
                    = "INSERT INTO pemesanan "
                    + "(id_user, id_jadwal, jumlah_tiket, total_harga) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getIdUser());
            ps.setInt(2, p.getIdJadwal());
            ps.setInt(3, p.getJumlahTiket());
            ps.setInt(4, p.getTotalHarga());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Query UPDATE
    public void updateKursi(int idJadwal, int sisaKursi) {
        try {
            String sql
                    = "UPDATE jadwal "
                    + "SET kursi_tersedia=? "
                    + "WHERE id_jadwal=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sisaKursi);
            ps.setInt(2, idJadwal);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
