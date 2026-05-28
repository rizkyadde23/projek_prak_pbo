package controllers;

import dao.PemesananDAO;
import java.util.ArrayList;
import models.Jadwal;
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

    public void bayarTiket(
            int idUser,
            Jadwal jadwal,
            int jumlahTiket,
            int totalHarga
    ) throws Exception {

        Pemesanan p = new Pemesanan();

        p.setIdUser(idUser);
        p.setIdJadwal(jadwal.getIdJadwal());
        p.setJumlahTiket(jumlahTiket);
        p.setTotalHarga(totalHarga);

        // INSERT PEMESANAN
        dao.insert(p);

        // UPDATE KURSI
        int sisaKursi = jadwal.getKursiTersedia() - jumlahTiket;

        jadwal.setKursiTersedia(sisaKursi);

        dao.updateKursi(
                jadwal.getIdJadwal(),
                sisaKursi
        );
    }
}
