package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DialogUtil {

    static {
        // ==========================================
        // STYLING GLOBAL UNTUK JOPTIONPANE
        // ==========================================

        // Background putih bersih
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        // Menambahkan padding/margin di dalam dialog agar tidak terlalu sempit
        UIManager.put("OptionPane.border", BorderFactory.createEmptyBorder(15, 25, 15, 25));

        // Pengaturan Font Modern
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 13));

        // Warna teks pesan (Slate 800 - Abu-abu sangat gelap agar tidak mencolok seperti hitam pekat)
        UIManager.put("OptionPane.messageForeground", new Color(30, 41, 59));

        // Menghilangkan kotak titik-titik (focus border) jadul saat tombol diklik
        UIManager.put("Button.focus", new Color(0, 0, 0, 0));

        // Memberi sedikit padding pada tombol bawaan OptionPane
        UIManager.put("Button.border", BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }

    private static String formatMessage(String message) {
        return "<html><div style='text-align: center; padding: 5px; color: #1e293b;'>"
                + message.replace("\n", "<br>")
                + "</div></html>";
    }

    private static ImageIcon getResizedIcon(String path, int size) {
        try {
            java.net.URL imgURL = DialogUtil.class.getResource(path);
            if (imgURL != null) {
                ImageIcon originalIcon = new ImageIcon(imgURL);
                Image originalImage = originalIcon.getImage();
                // Ubah ukuran gambar ke ukuran target dengan penskalaan halus
                Image resizedImage = originalImage.getScaledInstance(size, size, Image.SCALE_SMOOTH);
                return new ImageIcon(resizedImage);
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error resizing icon: " + e.getMessage());
            return null;
        }
    }

// Metode formatMessage Anda juga sudah sangat bagus, memberikan padding dan penyusunan yang bersih.
// Perbarui fungsi success untuk menggunakan fungsi pembantu di atas.
    public static void success(Component parent, String message) {
        // Ubah ukuran ikon ke ukuran yang lebih proporsional, misalnya 64x64 pixel
        ImageIcon icon = getResizedIcon("/assets/success.png", 32);

        JOptionPane.showMessageDialog(
                parent,
                formatMessage(message),
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE,
                icon
        );
    }

    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(
                parent,
                formatMessage(message),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static int confirm(Component parent, String message) {
        // Mengubah teks tombol bawaan "Yes" / "No" menjadi "Ya" / "Batal"
        Object[] options = {"Ya", "Batal"};

        return JOptionPane.showOptionDialog(
                parent,
                formatMessage(message),
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, // Jangan gunakan icon custom, gunakan default question icon
                options, // Masukkan array opsi tombol
                options[1] // Fokus default pada tombol "Batal" (mencegah klik tak sengaja)
        );
    }
}
