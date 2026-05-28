package view.admin;

import controllers.KeretaController;
import exceptions.ValidationException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Kereta;
import utils.DialogUtil;

public class KelolaKereta extends JFrame {

    // Controller
    private final KeretaController controller = new KeretaController();

    // Components
    private JTextField txtId;
    private JTextField txtNama;
    private JTextField txtAsal;
    private JTextField txtTujuan;

    private JButton btnSimpan;
    private JButton btnUpdate;
    private JButton btnHapus;
    private JButton btnReset;
    private JButton btnKembali;

    private JTable tableKereta;
    private DefaultTableModel tableModel; // Pindah ke global scope
    private JLabel lblTotalData; // Widget Baru
    private TableRowSorter<DefaultTableModel> rowSorter; // Widget Baru

    // Constructor
    public KelolaKereta() {
        initComponents();
        loadTable();

        setTitle("Kelola Kereta");
        setSize(1050, 700); // Ukuran default sedikit diperlebar agar lebih lega
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Sekarang aman jika diset resizable(true) atau MAXIMIZED_BOTH karena layout sudah responsif
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        Color bgColor = new Color(241, 245, 249);   // Abu-abu terang modern (Slate 100)
        Color headerColor = new Color(15, 23, 42);   // Biru dongker gelap (Slate 900)
        Color cardColor = Color.WHITE;

        Font titleFont = new Font("Segoe UI", Font.BOLD, 26);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        // =========================
        // ROOT PANEL
        // =========================
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(bgColor);

        // =========================
        // HEADER
        // =========================
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(headerColor);
        header.setBorder(new EmptyBorder(15, 30, 15, 30));

        JLabel lblTitle = new JLabel("Manajemen Data Kereta");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(titleFont);

        btnKembali = new JButton("Kembali ke Dashboard");
        btnKembali.setFocusPainted(false);
        btnKembali.setBackground(new Color(239, 68, 68));
        btnKembali.setForeground(Color.WHITE);
        btnKembali.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnKembali.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnKembali.setPreferredSize(new Dimension(220, 42)); // Diperpanjang secara proporsional

        btnKembali.addActionListener(e -> {
            new DashboardAdmin().setVisible(true);
            dispose();
        });

        header.add(lblTitle, BorderLayout.WEST);
        header.add(btnKembali, BorderLayout.EAST);

        // =========================
        // MAIN PANEL
        // =========================
        JPanel mainPanel = new JPanel(new BorderLayout(25, 0));
        mainPanel.setBackground(bgColor);
        mainPanel.setBorder(new EmptyBorder(25, 30, 30, 30));

        // =========================
        // FORM CARD (LEFT PANEL)
        // =========================
        JPanel formCard = new JPanel();
        formCard.setLayout(new BoxLayout(formCard, BoxLayout.Y_AXIS));
        formCard.setBackground(cardColor);
        formCard.setBorder(new EmptyBorder(25, 25, 25, 25));
        // Catatan: setPreferredSize dihapus dari formCard agar tingginya otomatis dihitung scrollbar

        JLabel formTitle = new JLabel("Form Data Kereta");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(headerColor);
        formTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtId = createTextField();
        txtId.setEnabled(false);
        txtNama = createTextField();
        txtAsal = createTextField();
        txtTujuan = createTextField();

        formCard.add(formTitle);
        formCard.add(Box.createVerticalStrut(20));

        formCard.add(createLabel("ID Kereta (Otomatis)", labelFont, headerColor));
        formCard.add(txtId);
        formCard.add(Box.createVerticalStrut(15));

        formCard.add(createLabel("Nama Kereta", labelFont, headerColor));
        formCard.add(txtNama);
        formCard.add(Box.createVerticalStrut(15));

        formCard.add(createLabel("Stasiun Asal", labelFont, headerColor));
        formCard.add(txtAsal);
        formCard.add(Box.createVerticalStrut(15));

        formCard.add(createLabel("Stasiun Tujuan", labelFont, headerColor));
        formCard.add(txtTujuan);

        // Menggunakan Strut pasti (bukan Glue) agar ScrollPane membaca tinggi asli komponen
        formCard.add(Box.createVerticalStrut(25));

        // =========================
        // BUTTON PANEL (GRID 2x2)
        // =========================
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 12, 12));
        buttonPanel.setBackground(cardColor);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 95)); // Kunci tinggi tombol agar tidak tenggelam

        btnSimpan = createButton("Tambah", new Color(16, 185, 129));
        btnUpdate = createButton("Update", new Color(59, 130, 246));
        btnReset = createButton("Bersihkan", new Color(241, 245, 249));
        btnReset.setForeground(headerColor); // Teks gelap untuk tombol bersihkan
        btnHapus = createButton("Hapus", new Color(239, 68, 68));

        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnHapus);

        formCard.add(buttonPanel);

        // Bungkus formCard ke dalam ScrollPane agar aman di resolusi layar mana pun
        JScrollPane scrollSidebar = new JScrollPane(formCard);
        scrollSidebar.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));
        scrollSidebar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSidebar.setPreferredSize(new Dimension(360, 0)); // Lebar sidebar dikunci di sini

        // =========================
        // TABLE CARD & WIDGETS (RIGHT PANEL)
        // =========================
        JPanel rightPanel = new JPanel(new BorderLayout(0, 15));
        rightPanel.setBackground(bgColor);

        // --- ATAS TABLE: Control Panel (Search & Stats Widget) ---
        JPanel tableControlPanel = new JPanel(new BorderLayout());
        tableControlPanel.setBackground(cardColor);
        tableControlPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(15, 20, 15, 20)
        ));

        // Widget Statistik Total Data (Kiri)
        JPanel statPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statPanel.setOpaque(false);
        JLabel tableTitle = new JLabel("Daftar Kereta Aktif");
        tableTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tableTitle.setForeground(headerColor);
        lblTotalData = new JLabel(" | Total: 0 Data");
        lblTotalData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalData.setForeground(Color.GRAY);
        statPanel.add(tableTitle);
        statPanel.add(lblTotalData);

        tableControlPanel.add(statPanel, BorderLayout.WEST);

        // --- SETUP TABLE ---
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama Kereta");
        tableModel.addColumn("Asal");
        tableModel.addColumn("Tujuan");

        tableGridSetup(fieldFont, headerColor);

        JScrollPane scrollPane = new JScrollPane(tableKereta);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));

        rightPanel.add(tableControlPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================
        // ACTIONS & EVENTS
        // =========================
        btnSimpan.addActionListener(e -> simpanData());
        btnUpdate.addActionListener(e -> updateData());
        btnReset.addActionListener(e -> resetForm());
        btnHapus.addActionListener(e -> hapusData());

        // Penyesuaian Klik Tabel (Aman dari Sorting & Filtering)
        tableKereta.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int viewRow = tableKereta.getSelectedRow();
                if (viewRow != -1) {
                    int row = tableKereta.convertRowIndexToModel(viewRow);
                    txtId.setText(tableModel.getValueAt(row, 0).toString());
                    txtNama.setText(tableModel.getValueAt(row, 1).toString());
                    txtAsal.setText(tableModel.getValueAt(row, 2).toString());
                    txtTujuan.setText(tableModel.getValueAt(row, 3).toString());
                }
            }
        });

        // =========================
        // CONSTRUCT PANELS
        // =========================
        mainPanel.add(scrollSidebar, BorderLayout.WEST); // Masukkan sidebar scrollable
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        root.add(header, BorderLayout.NORTH);
        root.add(mainPanel, BorderLayout.CENTER);

        add(root);
    }

    private void tableGridSetup(Font fieldFont, Color headerColor) {
        tableKereta = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableKereta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableKereta.getTableHeader().setReorderingAllowed(false);
        tableKereta.setRowHeight(35); // Baris tabel dibuat lebih tinggi & modern
        tableKereta.setFont(fieldFont);
        tableKereta.setSelectionBackground(new Color(219, 234, 254));
        tableKereta.setSelectionForeground(headerColor);

        // Styling Header Table
        tableKereta.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableKereta.getTableHeader().setBackground(new Color(37, 99, 235));
        tableKereta.getTableHeader().setForeground(Color.WHITE);
        tableKereta.getTableHeader().setPreferredSize(new Dimension(0, 40));

    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 40));
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setBackground(new Color(248, 250, 252));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                new EmptyBorder(8, 12, 8, 12)
        ));
        return textField;
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Memberi sedikit ruang aman antara field dengan label di atasnya
        label.setBorder(new EmptyBorder(0, 0, 5, 0));
        return label;
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder());
        return button;
    }

    // =========================
    // CRUD METHODS (UPDATED)
    // =========================
    private void simpanData() {
        try {
            controller.tambahKereta(
                    txtNama.getText(),
                    txtAsal.getText(),
                    txtTujuan.getText()
            );
            DialogUtil.success(this, "Data berhasil ditambahkan!");
            loadTable();
            resetForm();
        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void updateData() {
        try {
            controller.updateKereta(
                    txtId.getText(),
                    txtNama.getText(),
                    txtAsal.getText(),
                    txtTujuan.getText()
            );
            DialogUtil.success(this, "Data berhasil diupdate");
            loadTable();
            resetForm();
        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void hapusData() {
        try {
            if (txtId.getText().isEmpty()) {
                throw new ValidationException("Pilih data terlebih dahulu!");
            }
            int confirm = DialogUtil.confirm(this, "Yakin ingin menghapus data?");
            if (confirm == JOptionPane.YES_OPTION) {
                controller.hapusKereta(
                        txtId.getText());
                DialogUtil.success(this, "Data berhasil dihapus");
                loadTable();
                resetForm();
            }

        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtAsal.setText("");
        txtTujuan.setText("");
        tableKereta.clearSelection();
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        ArrayList<Kereta> list = controller.getAll();

        for (Kereta k : list) {
            Object[] row = {
                k.getIdKereta(),
                k.getNamaKereta(),
                k.getAsal(),
                k.getTujuan()
            };
            tableModel.addRow(row);
        }
        // Update data pada Label Widget secara Real-time
        lblTotalData.setText(" | Total: " + list.size() + " Data");
    }
}
