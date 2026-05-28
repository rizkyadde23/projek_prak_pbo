package controllers;

import dao.JadwalDAO;
import exceptions.TiketException;
import exceptions.ValidationException;
import java.util.ArrayList;
import models.Jadwal;

public class JadwalController {

    // Instansiasi DAO
    JadwalDAO dao = new JadwalDAO();

    // Method INSERT Jadwal
    public void insert(Jadwal jadwal) {
        dao.insert(jadwal);
    }

    // Method SELECT Jadwal
    public ArrayList<Jadwal> getAll() {
        return dao.getAll();
    }

    // Method UPDATE Jadwal
    public void update(Jadwal jadwal) {
        dao.update(jadwal);
    }

    // Method DELETE Jadwal
    public void delete(int id) {
        dao.delete(id);
    }

    // METHOD CHECKOUT
    public int checkout(
            Jadwal jadwal,
            String jumlahText
    ) throws TiketException, NumberFormatException {
        if (jadwal == null) {
            throw new TiketException(
                    "Silakan pilih jadwal keberangkatan terlebih dahulu!"
            );
        }
        if (jumlahText.trim().isEmpty()) {
            throw new TiketException(
                    "Masukkan jumlah tiket!"
            );
        }
        int jumlah = Integer.parseInt(jumlahText);
        if (jumlah <= 0) {
            throw new TiketException(
                    "Jumlah tiket minimal 1!"
            );
        }

        if (jumlah > jadwal.getKursiTersedia()) {
            throw new TiketException(
                    "Mohon maaf, sisa kursi tidak mencukupi!"
            );
        }
        return jumlah * jadwal.getHarga();
    }

    // GET SELECTED JADWAL
    public Jadwal getSelectedJadwal(int selectedRow, ArrayList<Jadwal> jadwalList) {
        if (selectedRow == -1) {
            return null;
        }
        return jadwalList.get(selectedRow);
    }

    public void tambahJadwal(
            String kereta,
            String tanggal,
            String jam,
            String asal,
            String tujuan,
            String harga,
            String kursi
    ) throws Exception {
        if (tanggal.isEmpty()
                || jam.isEmpty()
                || asal.isEmpty()
                || tujuan.isEmpty()
                || harga.isEmpty()
                || kursi.isEmpty()) {
            throw new ValidationException(
                    "Semua field wajib diisi!");
        }
        Jadwal jadwal = new Jadwal();
        int idKereta = Integer.parseInt(kereta.split(" - ")[0]);
        jadwal.setIdKereta(idKereta);
        jadwal.setTanggal(tanggal);
        jadwal.setJam(jam);
        jadwal.setAsal(asal);
        jadwal.setTujuan(tujuan);
        jadwal.setHarga(Integer.parseInt(harga));
        jadwal.setKursiTersedia(Integer.parseInt(kursi));
        insert(jadwal);
    }

    public void updateJadwal(
            String id,
            String kereta,
            String tanggal,
            String jam,
            String asal,
            String tujuan,
            String harga,
            String kursi
    ) throws Exception {
        if (id.isEmpty()) {
            throw new ValidationException(
                    "Pilih data terlebih dahulu!");
        }
        Jadwal jadwal = new Jadwal();
        int idKereta = Integer.parseInt(kereta.split(" - ")[0]);
        jadwal.setIdJadwal(Integer.parseInt(id));
        jadwal.setIdKereta(idKereta);
        jadwal.setTanggal(tanggal);
        jadwal.setJam(jam);
        jadwal.setAsal(asal);
        jadwal.setTujuan(tujuan);
        jadwal.setHarga(Integer.parseInt(harga));
        jadwal.setKursiTersedia(Integer.parseInt(kursi));
        update(jadwal);
    }

    public void hapusJadwal(String id) throws Exception {
        if (id.isEmpty()) {
            throw new ValidationException(
                    "Pilih data terlebih dahulu!");
        }
        delete(Integer.parseInt(id));
    }
}
