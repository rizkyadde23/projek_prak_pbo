package view.user;

import config.Session;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import view.login.LoginForm;

public class DashboardUser extends JFrame {

    // Components
    private JLabel lblTitle;
    private JLabel lblUser;
    private JLabel lblDate;

    private JButton btnPesanTiket;
    private JButton btnRiwayat;
    private JButton btnLogout;

    // Constructor
    public DashboardUser() {
        initComponents();
        setTitle("Dashboard User - E-Tiket");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // UI
    private void initComponents() {
        // ROOT PANEL
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(15, 23, 42));

        // ================= SIDEBAR =================
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(30, 41, 59));
        sidebar.setPreferredSize(new Dimension(300, getHeight())); // Lebar disesuaikan
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 25));

        // APP TITLE
        JLabel appTitle = new JLabel("E-TIKET");
        appTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        appTitle.setForeground(Color.WHITE);
        appTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel appSubtitle = new JLabel("Kereta Api Indonesia");
        appSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        appSubtitle.setForeground(new Color(148, 163, 184));
        appSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTON MENU
        btnPesanTiket = createMenuButton("Pesan Tiket");
        btnRiwayat = createMenuButton("Riwayat Pemesanan");
        btnLogout = createLogoutButton("Logout");

        // ACTION
        btnPesanTiket.addActionListener(e -> {
            new PesanTiket().setVisible(true);
            dispose();
        });

        btnRiwayat.addActionListener(e -> {
            new RiwayatPemesanan().setVisible(true);
            dispose();
        });

        btnLogout.addActionListener(e -> logout());

        // SIDEBAR ADD
        sidebar.add(appTitle);
        sidebar.add(Box.createVerticalStrut(5));
        sidebar.add(appSubtitle);
        sidebar.add(Box.createVerticalStrut(60));
        sidebar.add(btnPesanTiket);
        sidebar.add(Box.createVerticalStrut(15));
        sidebar.add(btnRiwayat);
        sidebar.add(Box.createVerticalGlue()); // Mendorong tombol logout ke bawah
        sidebar.add(btnLogout);

        // ================= MAIN CONTENT =================
        JPanel content = new JPanel();
        content.setBackground(new Color(241, 245, 249));
        content.setLayout(new BorderLayout());

        // --- HEADER SECTION (Top) ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(50, 60, 20, 60));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        lblTitle = new JLabel("Dashboard");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitle.setForeground(new Color(15, 23, 42));

        lblUser = new JLabel("Selamat Datang, " + Session.nama);
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        lblUser.setForeground(new Color(100, 116, 139));

        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblUser);

        // WIDGET: Tanggal Hari Ini
        String dateString = new SimpleDateFormat("EEEE, dd MMMM yyyy").format(new Date());
        lblDate = new JLabel(dateString);
        lblDate.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblDate.setForeground(new Color(37, 99, 235)); // Warna biru aksen
        lblDate.setHorizontalAlignment(SwingConstants.RIGHT);

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(lblDate, BorderLayout.EAST);

        // --- BODY SECTION (Center) ---
        JPanel bodyPanel = new JPanel();
        bodyPanel.setOpaque(false);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 60, 60, 60));

        // WIDGET: CARD MENU
        JPanel cardContainer = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 25));
        cardContainer.setOpaque(false);
        cardContainer.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel cardPesan = createCard("Pesan Tiket", "Cari dan pesan tiket perjalanan Anda");
        JPanel cardRiwayat = createCard("Riwayat", "Lihat daftar transaksi sebelumnya");
        // Card tambahan sebagai dekorasi
        JPanel cardPromo = createCard("Info Promo", "Cek diskon tiket kereta terbaru");

        cardContainer.add(cardPesan);
        cardContainer.add(Box.createHorizontalStrut(25));
        cardContainer.add(cardRiwayat);
        cardContainer.add(Box.createHorizontalStrut(25));
        cardContainer.add(cardPromo);

        // WIDGET: Papan Informasi / Jadwal Terdekat
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.WHITE);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        infoPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(25, 30, 25, 30)
        ));

        JLabel lblInfoTitle = new JLabel("Informasi Terkini");
        lblInfoTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblInfoTitle.setForeground(new Color(15, 23, 42));

        JLabel lblInfoDesc = new JLabel("Belum ada Informasi Tambahan");
        lblInfoDesc.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblInfoDesc.setForeground(new Color(100, 116, 139));

        infoPanel.add(lblInfoTitle);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(lblInfoDesc);

        // Susun Body
        bodyPanel.add(cardContainer);
        bodyPanel.add(Box.createVerticalStrut(40));
        bodyPanel.add(infoPanel);

        // Susun Konten
        content.add(headerPanel, BorderLayout.NORTH);
        content.add(bodyPanel, BorderLayout.CENTER);

        // ROOT ADD
        root.add(sidebar, BorderLayout.WEST);
        root.add(content, BorderLayout.CENTER);
        add(root);
    }

    // CUSTOM BUTTON
    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45)); // Agar lebar merata
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(51, 65, 85));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    // LOGOUT BUTTON
    private JButton createLogoutButton(String text) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(220, 38, 38));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    // CARD WIDGET
    private JPanel createCard(String title, String desc) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(300, 150));
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout()); // Menggunakan border layout agar rapi
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));

        // Warna aksen di bagian atas card
        JPanel accent = new JPanel();
        accent.setBackground(new Color(37, 99, 235));
        accent.setPreferredSize(new Dimension(300, 4));

        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel lblCardTitle = new JLabel(title);
        lblCardTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblCardTitle.setForeground(new Color(15, 23, 42));

        // Membungkus deskripsi agar membungkus ke bawah (wrap) jika panjang menggunakan html
        JLabel lblDesc = new JLabel("<html>" + desc + "</html>");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDesc.setForeground(new Color(100, 116, 139));

        textPanel.add(lblCardTitle);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(lblDesc);

        card.add(accent, BorderLayout.NORTH);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    // LOGOUT
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Session.clearSession();
            new LoginForm().setVisible(true);
            dispose();
        }
    }
}
