package controllers;

import dao.PemesananDAO;
import java.util.ArrayList;
import models.Pemesanan;

public class PemesananController {

    // Instansiasi DAO
    PemesananDAO dao = new PemesananDAO();

    // Method SELECT Riwayat Pemesanan
    public ArrayList<Pemesanan> getRiwayat(int idUser) {
        return dao.getRiwayat(idUser);
    }

    // Method INSERT Riwayat Pemesanan
    public void insert(Pemesanan p) {
        dao.insert(p);
    }

    // Method UPDATE Riwayat Pemesanan
    public void updateKursi(int idJadwal, int sisaKursi) {
        dao.updateKursi(idJadwal, sisaKursi);
    }
}
