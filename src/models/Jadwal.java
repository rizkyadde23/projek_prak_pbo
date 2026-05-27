package models;

public class Jadwal {

    // Encapsulation
    private int idJadwal;
    private int idKereta;
    private String namaKereta;
    private String tanggal;
    private String jam;
    private int harga;
    private int kursiTersedia;
    private String asal;
    private String tujuan;

    // Constructor
    public Jadwal() {
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
    public int getIdKereta() {
        return idKereta;
    }

    // Setter
    public void setIdKereta(int idKereta) {
        this.idKereta = idKereta;
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
    public int getHarga() {
        return harga;
    }

    // Setter
    public void setHarga(int harga) {
        if (harga < 0) {
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    // Getter
    public int getKursiTersedia() {
        return kursiTersedia;
    }

    // Setter
    public void setKursiTersedia(int kursiTersedia) {
        if (kursiTersedia < 0) {
            this.kursiTersedia = 0;
        } else {
            this.kursiTersedia = kursiTersedia;
        }
    }

    // Getter
    public String getAsal() {
        return asal;
    }

    // Setter
    public void setAsal(String asal) {
        this.asal = asal;
    }

    // Getter
    public String getTujuan() {
        return tujuan;
    }

    // Setter
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
}
