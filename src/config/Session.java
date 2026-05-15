package config;

public class Session {

    //Deklarasi Session User
    public static int idUser;
    public static String nama;
    public static String role;

    //Hapus Session User
    public static void clearSession() {
        idUser = 0;
        nama = null;
        role = null;
    }
}
