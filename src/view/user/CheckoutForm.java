package view.user;

import config.Session;
import controllers.PemesananController;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;
import models.Jadwal;
import utils.DialogUtil;

public class CheckoutForm extends JFrame {

    private final Jadwal jadwal;
    private final int jumlahTiket;
    private final int totalHarga;

    private JTextField txtKereta;
    private JTextField txtRute;
    private JTextField txtTanggal;
    private JTextField txtJam;
    private JTextField txtHarga;
    private JTextField txtJumlahTiket;
    private JLabel lblTotalHargaVal; // Diubah menjadi JLabel khusus untuk Widget Total

    private JButton btnBayar;
    private JButton btnEdit;

    private final NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("id", "ID"));

    PemesananController controller = new PemesananController();

    public CheckoutForm(Jadwal jadwal, int jumlahTiket, int totalHarga) {
        this.jadwal = jadwal;
        this.jumlahTiket = jumlahTiket;
        this.totalHarga = totalHarga;

        initComponents();
        tampilData();
        setTitle("Checkout Tiket - E-Tiket");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // ROOT PANEL (Menggunakan GridBagLayout untuk menengahkan Card)
        JPanel root = new JPanel(new GridBagLayout());
        root.setBackground(new Color(241, 245, 249)); // Latar abu-abu terang

        // CARD PANEL
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(550, 580));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(40, 40, 40, 40)
        ));

        // =========================
        // HEADER TITLE
        // =========================
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);
        titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTitle = new JLabel("Ringkasan Pesanan");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitle.setForeground(new Color(15, 23, 42));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Periksa kembali detail tiket Anda sebelum membayar");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitle.setForeground(new Color(100, 116, 139));
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblSubtitle);

        // =========================
        // DETAIL GRID (2 Kolom)
        // =========================
        JPanel gridPanel = new JPanel(new GridLayout(3, 2, 25, 20));
        gridPanel.setOpaque(false);
        gridPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtKereta = createField();
        txtRute = createField();
        txtTanggal = createField();
        txtJam = createField();
        txtHarga = createField();
        txtJumlahTiket = createField();

        gridPanel.add(createFieldContainer("Nama Kereta", txtKereta));
        gridPanel.add(createFieldContainer("Rute Perjalanan", txtRute));
        gridPanel.add(createFieldContainer("Tanggal Berangkat", txtTanggal));
        gridPanel.add(createFieldContainer("Waktu Berangkat", txtJam));
        gridPanel.add(createFieldContainer("Harga per Tiket", txtHarga));
        gridPanel.add(createFieldContainer("Jumlah Tiket", txtJumlahTiket));

        // =========================
        // WIDGET TOTAL PEMBAYARAN
        // =========================
        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBackground(new Color(239, 246, 255)); // Biru sangat muda
        totalPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        totalPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(191, 219, 254), 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JLabel lblTotalText = new JLabel("Total Pembayaran");
        lblTotalText.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotalText.setForeground(new Color(30, 58, 138));

        lblTotalHargaVal = new JLabel("Rp 0");
        lblTotalHargaVal.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTotalHargaVal.setForeground(new Color(29, 78, 216)); // Biru tua

        totalPanel.add(lblTotalText, BorderLayout.WEST);
        totalPanel.add(lblTotalHargaVal, BorderLayout.EAST);

        // =========================
        // BUTTONS
        // =========================
        btnBayar = new JButton("Bayar Sekarang");
        btnBayar.setBackground(new Color(37, 99, 235));
        btnBayar.setForeground(Color.WHITE);
        btnBayar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnBayar.setFocusPainted(false);
        btnBayar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBayar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btnBayar.addActionListener(e -> bayar());

        btnEdit = new JButton("Ubah Pesanan");
        btnEdit.setBackground(Color.WHITE);
        btnEdit.setForeground(new Color(239, 68, 68)); // Teks merah
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnEdit.setFocusPainted(false);
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEdit.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btnEdit.setBorder(BorderFactory.createLineBorder(new Color(239, 68, 68), 1)); // Outline merah
        btnEdit.addActionListener(e -> {
            new PesanTiket().setVisible(true);
            dispose();
        });

        // ADD ALL TO CARD
        card.add(titlePanel);
        card.add(Box.createVerticalStrut(35));
        card.add(gridPanel);
        card.add(Box.createVerticalStrut(25));
        card.add(totalPanel);
        card.add(Box.createVerticalStrut(30));
        card.add(btnBayar);
        card.add(Box.createVerticalStrut(12));
        card.add(btnEdit);

        root.add(card);
        add(root);
    }

    private JTextField createField() {
        JTextField field = new JTextField();
        field.setFont(new Font("Segoe UI", Font.BOLD, 15));
        field.setForeground(new Color(15, 23, 42));
        field.setBackground(new Color(248, 250, 252));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        field.setEditable(false);
        return field;
    }

    private JPanel createFieldContainer(String label, JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(new Color(100, 116, 139));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);

        return panel;
    }

    private void tampilData() {
        txtKereta.setText(jadwal.getNamaKereta());
        txtRute.setText(jadwal.getAsal() + " -> " + jadwal.getTujuan()); // Menggunakan simbol panah
        txtTanggal.setText(jadwal.getTanggal());
        txtJam.setText(jadwal.getJam());
        txtHarga.setText("Rp " + currencyFormat.format(jadwal.getHarga()));
        txtJumlahTiket.setText(jumlahTiket + " Tiket");

        lblTotalHargaVal.setText("Rp " + currencyFormat.format(totalHarga));
    }

    private void bayar() {
        try {
            controller.bayarTiket(
                    Session.idUser,
                    jadwal,
                    jumlahTiket,
                    totalHarga
            );
            DialogUtil.success(this, "Pembayaran berhasil!");
            new DashboardUser().setVisible(true);
            dispose();

        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }
}
