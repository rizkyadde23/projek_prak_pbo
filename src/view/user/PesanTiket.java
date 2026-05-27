package view.user;

import controllers.JadwalController;
import exceptions.TiketException;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Jadwal;

public class PesanTiket extends JFrame {

    // DATA
    private final ArrayList<Jadwal> jadwalList = new ArrayList<>();

    // CONTROLLER
    JadwalController jadwalController = new JadwalController();

    // COMPONENT
    private JTable tableJadwal;
    private JTextField txtKereta;
    private JTextField txtRute;
    private JTextField txtHarga;
    private JTextField txtKursi;
    private JTextField txtJumlah;

    private JButton btnCheckout;
    private JButton btnKembali;

    // FORMATTER
    private NumberFormat currencyFormat = NumberFormat.getInstance(new Locale("id", "ID"));

    // CONSTRUCTOR
    public PesanTiket() {
        initComponents();
        loadTable();

        setTitle("Pesan Tiket - E-Tiket");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // UI
    private void initComponents() {
        // ROOT
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(241, 245, 249));

        // ================= HEADER =================
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(15, 23, 42));
        header.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        JLabel lblTitle = new JLabel("PESAN TIKET KERETA");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblSubtitle = new JLabel("Pilih jadwal keberangkatan kereta yang tersedia");
        lblSubtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSubtitle.setForeground(new Color(148, 163, 184));

        titlePanel.add(lblTitle);
        titlePanel.add(Box.createVerticalStrut(5));
        titlePanel.add(lblSubtitle);

        btnKembali = new JButton("Kembali ke Dashboard");
        btnKembali.setBackground(new Color(239, 68, 68));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFocusPainted(false);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKembali.setPreferredSize(new Dimension(200, 45));
        btnKembali.addActionListener(e -> {
            new DashboardUser().setVisible(true);
            dispose();
        });

        header.add(titlePanel, BorderLayout.WEST);
        header.add(btnKembali, BorderLayout.EAST);

        // ================= MAIN PANEL =================
        JPanel mainPanel = new JPanel(new BorderLayout(30, 0)); // Gap horizontal antar panel
        mainPanel.setBackground(new Color(241, 245, 249));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // --- TABLE CARD PANEL ---
        JPanel tableCard = new JPanel(new BorderLayout());
        tableCard.setBackground(Color.WHITE);
        tableCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel lblTableTitle = new JLabel("Daftar Jadwal Kereta Api");
        lblTableTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTableTitle.setForeground(new Color(15, 23, 42));
        lblTableTitle.setBorder(new EmptyBorder(0, 0, 15, 0));

        String[] columns = {"ID", "Kereta", "Asal", "Tujuan", "Tanggal", "Jam", "Harga", "Kursi"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableJadwal = new JTable(model);
        tableJadwal.setRowHeight(40);
        tableJadwal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tableJadwal.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableJadwal.getTableHeader().setBackground(new Color(37, 99, 235));
        tableJadwal.getTableHeader().setForeground(Color.WHITE);
        tableJadwal.getTableHeader().setPreferredSize(new Dimension(100, 40));
        tableJadwal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJadwal.getTableHeader().setReorderingAllowed(false);
        tableJadwal.setSelectionBackground(new Color(191, 219, 254));
        tableJadwal.setGridColor(new Color(226, 232, 240));
        tableJadwal.setShowVerticalLines(false);

        // Menengahkan text pada tabel
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tableJadwal.getColumnCount(); i++) {
            tableJadwal.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tableJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClicked();
            }
        });

        JScrollPane scrollPane = new JScrollPane(tableJadwal);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        tableCard.add(lblTableTitle, BorderLayout.NORTH);
        tableCard.add(scrollPane, BorderLayout.CENTER);

        // --- FORM CARD PANEL ---
        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setPreferredSize(new Dimension(380, 0)); // Diperlebar sedikit
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
                BorderFactory.createEmptyBorder(30, 30, 30, 30)
        ));

        JLabel lblForm = new JLabel("Detail Pemesanan");
        lblForm.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblForm.setForeground(new Color(15, 23, 42));
        lblForm.setAlignmentX(Component.LEFT_ALIGNMENT);

        // FIELD INITIALIZATION
        txtKereta = createTextField(false);
        txtRute = createTextField(false);
        txtHarga = createTextField(false);
        txtKursi = createTextField(false);
        txtJumlah = createTextField(true);

        // BUTTON CHECKOUT
        btnCheckout = new JButton("Lanjutkan ke Checkout");
        btnCheckout.setBackground(new Color(37, 99, 235));
        btnCheckout.setForeground(Color.WHITE);
        btnCheckout.setFocusPainted(false);
        btnCheckout.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnCheckout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCheckout.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        btnCheckout.addActionListener(e -> checkout());

        // ADD TO FORM
        formPanel.add(lblForm);
        formPanel.add(Box.createVerticalStrut(25));
        formPanel.add(createField("Nama Kereta", txtKereta));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Rute (Asal - Tujuan)", txtRute));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Harga Tiket", txtHarga));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Kursi Tersedia", txtKursi));
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(createField("Jumlah Tiket Dipesan", txtJumlah));
        formPanel.add(Box.createVerticalStrut(35));
        formPanel.add(btnCheckout);

        // MAIN ADD
        mainPanel.add(tableCard, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.EAST);

        // ROOT ADD
        root.add(header, BorderLayout.NORTH);
        root.add(mainPanel, BorderLayout.CENTER);

        add(root);
    }

    // FIELD COMPONENT BUILDER
    private JPanel createField(String label, JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lbl.setForeground(new Color(71, 85, 105));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);

        return panel;
    }

    // TEXTFIELD STYLE
    private JTextField createTextField(boolean editable) {
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        field.setPreferredSize(new Dimension(250, 45));
        field.setEditable(editable);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 15));

        // Membedakan background jika field readonly
        if (!editable) {
            field.setBackground(new Color(241, 245, 249));
            field.setForeground(new Color(100, 116, 139));
        } else {
            field.setBackground(Color.WHITE);
            field.setForeground(new Color(15, 23, 42));
        }

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        return field;
    }

    // TABLE CLICK
    private void tableClicked() {
        Jadwal jadwal = getSelectedJadwal();
        if (jadwal != null) {
            txtKereta.setText(jadwal.getNamaKereta());
            txtRute.setText(jadwal.getAsal() + " -> " + jadwal.getTujuan()); // Panah rute
            txtHarga.setText("Rp " + currencyFormat.format(jadwal.getHarga()));
            txtKursi.setText(String.valueOf(jadwal.getKursiTersedia()));

            // Set default jumlah 1 jika diklik
            if (txtJumlah.getText().isEmpty()) {
                txtJumlah.setText("1");
            }
        }
    }

    // CHECKOUT
    private void checkout() {
        try {
            Jadwal jadwal = getSelectedJadwal();

            if (jadwal == null) {
                throw new TiketException("Silakan pilih jadwal keberangkatan terlebih dahulu!");
            }

            if (txtJumlah.getText().trim().isEmpty()) {
                throw new TiketException("Masukkan jumlah tiket!");
            }

            int jumlah = Integer.parseInt(txtJumlah.getText());

            if (jumlah <= 0) {
                throw new TiketException("Jumlah tiket minimal 1!");
            }

            if (jumlah > jadwal.getKursiTersedia()) {
                throw new TiketException("Mohon maaf, sisa kursi tidak mencukupi!");
            }

            int total = jumlah * jadwal.getHarga();

            new CheckoutForm(jadwal, jumlah, total).setVisible(true);
            dispose();

        } catch (TiketException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Peringatan", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah tiket harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // GET SELECTED
    private Jadwal getSelectedJadwal() {
        int selectedRow = tableJadwal.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        }
        return jadwalList.get(selectedRow);
    }

    // LOAD TABLE
    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tableJadwal.getModel();
        model.setRowCount(0);
        jadwalList.clear();

        ArrayList<Jadwal> list = jadwalController.getAll();

        for (Jadwal j : list) {
            jadwalList.add(j);
            Object[] row = {
                j.getIdJadwal(),
                j.getNamaKereta(),
                j.getAsal(),
                j.getTujuan(),
                j.getTanggal(),
                j.getJam(),
                "Rp " + currencyFormat.format(j.getHarga()), // Format harga
                j.getKursiTersedia()
            };
            model.addRow(row);
        }
    }
}
