package view.user;

import config.Session;
import controllers.PemesananController;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Pemesanan;

public class RiwayatPemesanan extends JFrame {

    private JTable tableRiwayat;
    private JButton btnKembali;
    private JLabel lblTitle;
    private JLabel lblSubtitle;

    // Label untuk Widget Ringkasan
    private JLabel lblValTransaksi;
    private JLabel lblValTiket;
    private JLabel lblValPengeluaran;

    // Instansiasi Controller
    PemesananController controller = new PemesananController();

    // Constructor
    public RiwayatPemesanan() {
        initComponents();
        loadTable(); // Load data sekaligus menghitung nilai pada widget

        setTitle("Riwayat Pemesanan - E-Tiket");
        setSize(1100, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // ROOT PANEL
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(241, 245, 249)); // Latar abu-abu terang ala dashboard modern

        // =========================
        // HEADER PANEL
        // =========================
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(30, 41, 59));
        headerPanel.setBorder(new EmptyBorder(25, 40, 25, 40));
        headerPanel.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));

        lblTitle = new JLabel("RIWAYAT PEMESANAN");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);

        lblSubtitle = new JLabel("Lihat semua tiket yang pernah kamu pesan, " + Session.nama);
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSubtitle.setForeground(new Color(203, 213, 225));

        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblSubtitle);

        btnKembali = new JButton("Kembali ke Dashboard");
        btnKembali.setFocusPainted(false);
        btnKembali.setBackground(new Color(239, 68, 68));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.setPreferredSize(new Dimension(200, 45));
        btnKembali.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKembali.addActionListener(e -> {
            new DashboardUser().setVisible(true);
            dispose();
        });

        headerPanel.add(titlePanel, BorderLayout.WEST);
        headerPanel.add(btnKembali, BorderLayout.EAST);

        // =========================
        // WIDGET SUMMARY PANEL
        // =========================
        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 0));
        summaryPanel.setOpaque(false);
        summaryPanel.setBorder(new EmptyBorder(0, 0, 25, 0));

        lblValTransaksi = new JLabel("0");
        lblValTiket = new JLabel("0");
        lblValPengeluaran = new JLabel("Rp 0");

        summaryPanel.add(createSummaryCard("Total Transaksi", lblValTransaksi, new Color(59, 130, 246)));
        summaryPanel.add(createSummaryCard("Total Tiket Dipesan", lblValTiket, new Color(16, 185, 129)));
        summaryPanel.add(createSummaryCard("Total Pengeluaran", lblValPengeluaran, new Color(245, 158, 11)));

        // =========================
        // TABLE PANEL
        // =========================
        String[] columns = {
            "ID", "Kereta", "Asal", "Tujuan", "Tanggal", "Jam", "Jumlah Tiket", "Total Harga"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableRiwayat = new JTable(model);
        tableRiwayat.setRowHeight(40); // Sedikit diperbesar agar lega
        tableRiwayat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tableRiwayat.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableRiwayat.getTableHeader().setBackground(new Color(37, 99, 235));
        tableRiwayat.getTableHeader().setForeground(Color.WHITE);
        tableRiwayat.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tableRiwayat.setSelectionBackground(new Color(191, 219, 254));
        tableRiwayat.setGridColor(new Color(226, 232, 240));
        tableRiwayat.setShowVerticalLines(false);

        // CENTER TABLE TEXT
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableRiwayat.getColumnCount(); i++) {
            tableRiwayat.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JScrollPane scrollPane = new JScrollPane(tableRiwayat);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        // =========================
        // CARD CONTAINER (Table Wrap)
        // =========================
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel lblInfo = new JLabel("Daftar Perjalanan Anda");
        lblInfo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblInfo.setForeground(new Color(15, 23, 42));
        lblInfo.setBorder(new EmptyBorder(0, 0, 15, 0));

        cardPanel.add(lblInfo, BorderLayout.NORTH);
        cardPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================
        // MAIN CONTENT
        // =========================
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        contentPanel.add(summaryPanel, BorderLayout.NORTH);
        contentPanel.add(cardPanel, BorderLayout.CENTER);

        // ADD TO ROOT
        root.add(headerPanel, BorderLayout.NORTH);
        root.add(contentPanel, BorderLayout.CENTER);

        add(root);
    }

    // Helper untuk membuat Widget Ringkasan (Cards)
    private JPanel createSummaryCard(String title, JLabel lblValue, Color accentColor) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setPreferredSize(new Dimension(280, 100));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        // Garis aksen warna di atas card
        JPanel topAccent = new JPanel();
        topAccent.setBackground(accentColor);
        topAccent.setPreferredSize(new Dimension(280, 4));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTitle.setForeground(new Color(100, 116, 139));

        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblValue.setForeground(new Color(15, 23, 42));

        textPanel.add(lblTitle);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(lblValue);

        card.add(topAccent, BorderLayout.NORTH);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    // FUNCTION LOAD TABLE & CALCULATE WIDGETS
    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tableRiwayat.getModel();
        model.setRowCount(0);

        ArrayList<Pemesanan> list = controller.getRiwayat(Session.idUser);

        // Variabel untuk menghitung widget ringkasan
        int totalTransaksi = list.size();
        int totalTiket = 0;
        long totalPengeluaran = 0;

        // Formatter untuk mata uang Rupiah
        NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("id", "ID"));

        for (Pemesanan p : list) {
            Object[] row = {
                p.getIdPemesanan(),
                p.getNamaKereta(),
                p.getAsal(),
                p.getTujuan(),
                p.getTanggal(),
                p.getJam(),
                p.getJumlahTiket(),
                "Rp " + currencyFormat.format(p.getTotalHarga())
            };
            model.addRow(row);

            // Proses Kalkulasi
            totalTiket += p.getJumlahTiket();
            totalPengeluaran += p.getTotalHarga();
        }

        // Update Label Widget
        lblValTransaksi.setText(String.valueOf(totalTransaksi));
        lblValTiket.setText(String.valueOf(totalTiket));
        lblValPengeluaran.setText("Rp " + currencyFormat.format(totalPengeluaran));
    }
}
