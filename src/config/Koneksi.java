package config;

import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    // Deklarasi Koneksi
    private static Connection koneksi;

    // Method getConnection
    public static Connection getConnection() throws DatabaseException {
        if (koneksi == null) {
            try {
                // Import Driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                // URL Database
                String url = "jdbc:mysql://localhost:3306/pbo_tiket_kereta";
                String user = "root";
                String password = "";
                // Koneksi Database
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Database Berhasil!");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver Tidak Ditemukan!");
                System.out.println(e);
            } catch (SQLException e) {
                System.out.println("Koneksi Database Gagal!");
                System.out.println(e);
            } catch (Exception e) {
                throw new DatabaseException("Gagal mengambil data!");
            }
        }
        // Mengembalikan Koneksi
        return koneksi;
    }
}
