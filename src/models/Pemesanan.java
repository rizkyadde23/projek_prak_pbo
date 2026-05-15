package models;

public class Pemesanan {

    // Encapsulation
    private int idPemesanan;
    private int idUser;
    private int idJadwal;
    private int jumlahTiket;
    private int totalHarga;
    private String namaKereta;
    private String tanggal;
    private String jam;

    //Constructor
    public Pemesanan() {
    }

    // Getter
    public String getNamaKereta() {
        return namaKereta;
    }

    // Setter
    public void setNamaKereta(String namaKereta) {
        this.namaKereta = namaKereta;
    }

    // Getter
    public String getTanggal() {
        return tanggal;
    }

    // Setter
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    // Getter
    public String getJam() {
        return jam;
    }

    // Setter
    public void setJam(String jam) {
        this.jam = jam;
    }

    // Getter
    public int getIdPemesanan() {
        return idPemesanan;
    }

    // Setter
    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    // Getter
    public int getIdUser() {
        return idUser;
    }

    // Setter
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    // Getter
    public int getIdJadwal() {
        return idJadwal;
    }

    // Setter
    public void setIdJadwal(int idJadwal) {
        this.idJadwal = idJadwal;
    }

    // Getter
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    // Setter
    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    // Getter
    public int getTotalHarga() {
        return totalHarga;
    }

    // Setter
    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}
