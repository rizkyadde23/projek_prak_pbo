package view.admin;

import config.Session;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import view.login.LoginForm;

public class DashboardAdmin extends JFrame {

    private JLabel lblTitle;
    private JLabel lblWelcome;
    private JLabel lblClock;

    private JButton btnLogout;

    // Constructor
    public DashboardAdmin() {
        initComponents();
        startClock();

        setTitle("Dashboard Admin - E-Tiket");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // ROOT PANEL
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(241, 245, 249)); // Latar abu-abu terang

        // ================= HEADER PANEL =================
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(15, 23, 42)); // Biru dongker
        headerPanel.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));

        // TITLE & CLOCK
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        lblTitle = new JLabel("ADMIN DASHBOARD");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);

        lblClock = new JLabel("Loading time...");
        lblClock.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblClock.setForeground(new Color(148, 163, 184));

        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblClock);

        // WELCOME & LOGOUT
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        userPanel.setOpaque(false);

        lblWelcome = new JLabel("Selamat datang, " + Session.nama);
        lblWelcome.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblWelcome.setForeground(new Color(226, 232, 240));

        btnLogout = new JButton("Logout");
        btnLogout.setBackground(new Color(239, 68, 68));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogout.setFocusPainted(false);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setPreferredSize(new Dimension(100, 40));
        btnLogout.addActionListener(e -> logout());

        userPanel.add(lblWelcome);
        userPanel.add(btnLogout);

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(userPanel, BorderLayout.EAST);

        // ================= MAIN CONTENT PANEL =================
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(241, 245, 249));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        // -- STATS PANEL (WIDGET INFO) --
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 25, 0)); // 3 Kolom Grid
        statsPanel.setOpaque(false);
        statsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        statsPanel.add(createStatCard("Total Kereta", "Atur Armada", new Color(16, 185, 129)));
        statsPanel.add(createStatCard("Jadwal Aktif", "Rute Tersedia", new Color(245, 158, 11)));
        statsPanel.add(createStatCard("Sistem Status", "Online / Normal", new Color(99, 102, 241)));

        // -- MENU PANEL --
        JPanel menuPanel = new JPanel(new GridLayout(1, 2, 30, 0)); // 2 Kolom Grid
        menuPanel.setOpaque(false);
        menuPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 250));

        // CARD KERETA
        JPanel keretaCard = createMenuCard(
                "Kelola Kereta",
                "Tambah, edit, perbarui, dan hapus data armada kereta yang terdaftar di sistem.",
                new Color(37, 99, 235),
                e -> {
                    new KelolaKereta().setVisible(true);
                    dispose();
                }
        );

        // CARD JADWAL
        JPanel jadwalCard = createMenuCard(
                "Kelola Jadwal",
                "Atur jadwal keberangkatan, rute, harga, dan ketersediaan kursi kereta api.",
                new Color(14, 165, 233),
                e -> {
                    new KelolaJadwal().setVisible(true);
                    dispose();
                }
        );

        menuPanel.add(keretaCard);
        menuPanel.add(jadwalCard);

        // -- ADD TO MAIN PANEL --
        mainPanel.add(statsPanel);
        mainPanel.add(Box.createVerticalStrut(40)); // Spasi antar baris
        mainPanel.add(menuPanel);
        mainPanel.add(Box.createVerticalGlue()); // Mendorong konten ke atas

        // ================= ROOT ADD =================
        root.add(headerPanel, BorderLayout.NORTH);
        root.add(mainPanel, BorderLayout.CENTER);

        add(root);
    }

    // CLOCK METHOD
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy | HH:mm:ss");
            lblClock.setText(formatter.format(new Date()));
        });
        timer.start();
    }

    // WIDGET STAT CARD BUILDER
    private JPanel createStatCard(String title, String subtitle, Color accentColor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(4, 0, 0, 0, accentColor), // Garis atas berwarna
                BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(15, 23, 42));

        JLabel lblSub = new JLabel(subtitle);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSub.setForeground(new Color(100, 116, 139));

        card.add(lblTitle, BorderLayout.NORTH);
        card.add(lblSub, BorderLayout.CENTER);

        return card;
    }

    // MENU CARD BUILDER
    private JPanel createMenuCard(String title, String description, Color buttonColor, ActionListener action) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        JLabel lblMenuTitle = new JLabel(title);
        lblMenuTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblMenuTitle.setForeground(new Color(15, 23, 42));

        JLabel lblDesc = new JLabel("<html><body style='width: 100%; color: #64748b;'>" + description + "</body></html>");
        lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JButton btnOpen = new JButton("Buka Menu");
        btnOpen.setBackground(buttonColor);
        btnOpen.setForeground(Color.WHITE);
        btnOpen.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnOpen.setFocusPainted(false);
        btnOpen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnOpen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));

        // Memasang action listener secara langsung
        btnOpen.addActionListener(action);

        card.add(lblMenuTitle);
        card.add(Box.createVerticalStrut(15));
        card.add(lblDesc);
        card.add(Box.createVerticalGlue());
        card.add(Box.createVerticalStrut(20));
        card.add(btnOpen);

        return card;
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin keluar dari sistem?",
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
