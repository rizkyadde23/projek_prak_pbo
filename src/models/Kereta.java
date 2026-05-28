package models;

public class Kereta {

    // Encapsulation
    private int idKereta;
    private String namaKereta;

    // Constructor
    public Kereta() {
    }

    // Polymorphism Constructor
    public Kereta(int idKereta, String namaKereta, String asal, String tujuan) {
        this.idKereta = idKereta;
        this.namaKereta = namaKereta;
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
}
