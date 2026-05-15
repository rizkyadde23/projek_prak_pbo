package models;

public class Kereta {

    // Encapsulation
    private int idKereta;
    private String namaKereta;
    private String asal;
    private String tujuan;

    // Constructor
    public Kereta() {
    }

    // Polymorphism Constructor
    public Kereta(int idKereta, String namaKereta, String asal, String tujuan) {
        this.idKereta = idKereta;
        this.namaKereta = namaKereta;
        this.asal = asal;
        this.tujuan = tujuan;
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
