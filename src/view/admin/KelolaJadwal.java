package view.admin;

import controllers.JadwalController;
import controllers.KeretaController;
import exceptions.ValidationException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import models.Jadwal;
import models.Kereta;
import utils.DialogUtil;

public class KelolaJadwal extends JFrame {

    private JTextField txtId;
    private JTextField txtTanggal;
    private JTextField txtJam;
    private JTextField txtHarga;
    private JTextField txtKursi;
    private JTextField txtAsal;    // Baru
    private JTextField txtTujuan;  // Baru

    private JComboBox<String> cbKereta;
    private JTable tableJadwal;
    private JLabel lblTotalData; // Widget Baru

    private JButton btnSimpan;
    private JButton btnReset;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnKembali;

    private DefaultTableModel tableModel;

    JadwalController controller = new JadwalController();
    KeretaController keretaController = new KeretaController();

    public KelolaJadwal() {
        initComponents();
        loadKereta();
        loadTable();

        setTitle("Kelola Jadwal - E-Tiket Admin");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        Color bgColor = new Color(241, 245, 249); // Abu-abu terang
        Color headerColor = new Color(15, 23, 42); // Biru dongker
        Color cardColor = Color.WHITE;

        Font titleFont = new Font("Segoe UI", Font.BOLD, 26);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        // ROOT PANEL
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(bgColor);

        // ================= HEADER =================
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(headerColor);
        header.setBorder(new EmptyBorder(15, 30, 15, 30));

        JLabel lblTitle = new JLabel("Manajemen Jadwal Kereta");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(titleFont);

        btnKembali = new JButton("Kembali ke Dashboard");
        styleButton(btnKembali, new Color(239, 68, 68), Color.WHITE);
        btnKembali.setPreferredSize(new Dimension(220, 42)); // Ukuran diperpanjang di sini
        btnKembali.addActionListener(e -> {
            new DashboardAdmin().setVisible(true);
            dispose();
        });

        header.add(lblTitle, BorderLayout.WEST);
        header.add(btnKembali, BorderLayout.EAST);

        // ================= MAIN CONTENT =================
        JPanel content = new JPanel(new BorderLayout(25, 0));
        content.setBackground(bgColor);
        content.setBorder(new EmptyBorder(25, 30, 30, 30));

        // ---------------- LEFT PANEL (FORM SIDEBAR) ----------------
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(cardColor);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        // CATATAN: line setPreferredSize di leftPanel SUDAH DIHAPUS
        // agar tingginya dihitung otomatis oleh JScrollPane
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(25, 25, 25, 25)
        ));

        JLabel formTitle = new JLabel("Form Data Jadwal");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(headerColor);
        formTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        leftPanel.add(formTitle);
        leftPanel.add(Box.createVerticalStrut(20));

        txtId = createField(fieldFont);
        txtId.setEnabled(false);
        txtTanggal = createField(fieldFont);
        txtJam = createField(fieldFont);
        txtAsal = createField(fieldFont);
        txtTujuan = createField(fieldFont);
        txtHarga = createField(fieldFont);
        txtKursi = createField(fieldFont);

        cbKereta = new JComboBox<>();
        cbKereta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        cbKereta.setFont(fieldFont);
        cbKereta.setBackground(Color.WHITE);

        addField(leftPanel, "ID Jadwal (Otomatis)", txtId, labelFont);
        addField(leftPanel, "Pilih Kereta", cbKereta, labelFont);
        addField(leftPanel, "Tanggal Berangkat (YYYY-MM-DD)", txtTanggal, labelFont);
        addField(leftPanel, "Waktu Berangkat (HH:MM:SS)", txtJam, labelFont);
        addField(leftPanel, "Stasiun Asal", txtAsal, labelFont);
        addField(leftPanel, "Stasiun Tujuan", txtTujuan, labelFont);
        addField(leftPanel, "Harga Tiket (Rp)", txtHarga, labelFont);
        addField(leftPanel, "Kapasitas Kursi", txtKursi, labelFont);

        // GANTI GLUE MENJADI STRUT: Di dalam ScrollPane, gunakan jarak pasti (Strut), jangan Glue.
        leftPanel.add(Box.createVerticalStrut(20));

        // Tombol Aksi (Grid 2x2)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 12, 12));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 95));

        btnSimpan = new JButton("Tambah");
        btnUpdate = new JButton("Update");
        btnReset = new JButton("Bersihkan");
        btnDelete = new JButton("Hapus");

        styleButton(btnSimpan, new Color(16, 185, 129), Color.WHITE);
        styleButton(btnUpdate, new Color(59, 130, 246), Color.WHITE);
        styleButton(btnReset, new Color(241, 245, 249), new Color(15, 23, 42));
        styleButton(btnDelete, new Color(239, 68, 68), Color.WHITE);

        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnDelete);

        leftPanel.add(buttonPanel);

        // ---------------- RIGHT PANEL (TABLE & WIDGETS) ----------------
        JPanel rightPanel = new JPanel(new BorderLayout(0, 15));
        rightPanel.setBackground(bgColor);

        // Top Control (Stats)
        JPanel tableControlPanel = new JPanel(new BorderLayout());
        tableControlPanel.setBackground(cardColor);
        tableControlPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(226, 232, 240)),
                new EmptyBorder(15, 20, 15, 20)
        ));

        // Widget Total Data
        JPanel statPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        statPanel.setOpaque(false);
        JLabel lblTblTitle = new JLabel("Daftar Jadwal Aktif");
        lblTblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTblTitle.setForeground(headerColor);
        lblTotalData = new JLabel(" | Total: 0 Data");
        lblTotalData.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTotalData.setForeground(Color.GRAY);
        statPanel.add(lblTblTitle);
        statPanel.add(lblTotalData);

        // Add Control Panel
        tableControlPanel.add(statPanel, BorderLayout.WEST);

        // Table Setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama Kereta");
        tableModel.addColumn("Tanggal");
        tableModel.addColumn("Jam");
        tableModel.addColumn("Asal");   // Baru
        tableModel.addColumn("Tujuan"); // Baru
        tableModel.addColumn("Harga");
        tableModel.addColumn("Kursi Tersedia");
        tableJadwal = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableJadwal.setRowHeight(35);
        tableJadwal.setFont(fieldFont);
        tableJadwal.setSelectionBackground(new Color(219, 234, 254)); // Biru muda saat dipilih
        tableJadwal.setSelectionForeground(headerColor);
        tableJadwal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableJadwal.getTableHeader().setReorderingAllowed(false);

        // Header Table Styling
        tableJadwal.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tableJadwal.getTableHeader().setBackground(new Color(37, 99, 235));
        tableJadwal.getTableHeader().setForeground(Color.WHITE);
        tableJadwal.getTableHeader().setPreferredSize(new Dimension(0, 40));

        JScrollPane scrollPane = new JScrollPane(tableJadwal);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240)));

        rightPanel.add(tableControlPanel, BorderLayout.NORTH);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // ADD TO CONTENT
        // Bungkus leftPanel dengan JScrollPane agar aman dari pemotongan layar
        JScrollPane scrollSidebar = new JScrollPane(leftPanel);
        scrollSidebar.setBorder(null); // Hilangkan border bawaan scrollpane
        scrollSidebar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSidebar.setPreferredSize(new Dimension(380, 0)); // Terapkan lebar tetap 380 di sini

        content.add(scrollSidebar, BorderLayout.WEST); // Masukkan scrollSidebar, bukan leftPanel
        content.add(rightPanel, BorderLayout.CENTER);

        // ADD ROOT
        root.add(header, BorderLayout.NORTH);
        root.add(content, BorderLayout.CENTER);

        add(root);

        // ================= ACTIONS =================
        btnSimpan.addActionListener(e -> tambahData());
        btnUpdate.addActionListener(e -> updateData());
        btnDelete.addActionListener(e -> deleteData());
        btnReset.addActionListener(e -> resetForm());

        tableJadwal.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                pilihTable();
            }
        });
    }

    private JTextField createField(Font font) {
        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        field.setPreferredSize(new Dimension(100, 40));
        field.setFont(font);
        field.setBackground(new Color(248, 250, 252));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(203, 213, 225), 1),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        return field;
    }

    private void addField(JPanel panel, String label, JComponent field, Font labelFont) {
        JLabel lbl = new JLabel(label);
        lbl.setFont(labelFont);
        lbl.setForeground(new Color(71, 85, 105));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(lbl);
        panel.add(Box.createVerticalStrut(5));
        panel.add(field);
        panel.add(Box.createVerticalStrut(15));
    }

    private void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(120, 42));
        if (bgColor.equals(new Color(241, 245, 249))) {
            button.setBorder(BorderFactory.createLineBorder(new Color(203, 213, 225)));
        } else {
            button.setBorder(BorderFactory.createEmptyBorder());
        }
    }

    private void tambahData() {
        try {
            controller.tambahJadwal(
                    cbKereta.getSelectedItem().toString(),
                    txtTanggal.getText(),
                    txtJam.getText(),
                    txtAsal.getText(),
                    txtTujuan.getText(),
                    txtHarga.getText(),
                    txtKursi.getText()
            );
            DialogUtil.success(this, "Jadwal berhasil ditambahkan!");
            loadTable();
            resetForm();
        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void updateData() {
        try {
            controller.updateJadwal(
                    txtId.getText(),
                    cbKereta.getSelectedItem().toString(),
                    txtTanggal.getText(),
                    txtJam.getText(),
                    txtAsal.getText(),
                    txtTujuan.getText(),
                    txtHarga.getText(),
                    txtKursi.getText()
            );
            DialogUtil.success(this, "Data jadwal berhasil diperbarui!");
            loadTable();
            resetForm();
        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void deleteData() {
        try {
            if (txtId.getText().isEmpty()) {
                throw new ValidationException("Pilih data terlebih dahulu!");
            }
            int confirm = DialogUtil.confirm(this, "Apakah Anda Yakin Ingin Menghapus Data Ini?");
            if (confirm == JOptionPane.YES_OPTION) {
                controller.hapusJadwal(txtId.getText());
                DialogUtil.success(this, "Data Berhasil Dihapus");
                loadTable();
                resetForm();
            }
        } catch (Exception e) {
            DialogUtil.error(this, e.getMessage());
        }
    }

    private void pilihTable() {
        int viewRow = tableJadwal.getSelectedRow();
        if (viewRow == -1) {
            return;
        }
        int modelRow = tableJadwal.convertRowIndexToModel(viewRow);
        txtId.setText(tableModel.getValueAt(modelRow, 0).toString());
        String namaKereta = tableModel.getValueAt(modelRow, 1).toString();
        for (int i = 0; i < cbKereta.getItemCount(); i++) {
            if (cbKereta.getItemAt(i).contains(namaKereta)) {
                cbKereta.setSelectedIndex(i);
                break;
            }
        }
        txtTanggal.setText(tableModel.getValueAt(modelRow, 2).toString());
        txtJam.setText(tableModel.getValueAt(modelRow, 3).toString());
        txtAsal.setText(tableModel.getValueAt(modelRow, 4).toString());   // Baru (Index 4)
        txtTujuan.setText(tableModel.getValueAt(modelRow, 5).toString()); // Baru (Index 5)
        txtHarga.setText(tableModel.getValueAt(modelRow, 6).toString());  // Bergeser ke 6
        txtKursi.setText(tableModel.getValueAt(modelRow, 7).toString());  // Bergeser ke 7
    }

    private void resetForm() {
        txtId.setText("");
        txtTanggal.setText("");
        txtJam.setText("");
        txtAsal.setText("");   // Baru
        txtTujuan.setText(""); // Baru
        txtHarga.setText("");
        txtKursi.setText("");
        if (cbKereta.getItemCount() > 0) {
            cbKereta.setSelectedIndex(0);
        }
        tableJadwal.clearSelection();
    }

    private void loadKereta() {
        cbKereta.removeAllItems();
        ArrayList<Kereta> list = keretaController.getAll();
        for (Kereta k : list) {
            cbKereta.addItem(k.getIdKereta() + " - " + k.getNamaKereta());
        }
    }

    private void loadTable() {
        tableModel.setRowCount(0);
        ArrayList<Jadwal> list = controller.getAll();
        for (Jadwal j : list) {
            Object[] row = {
                j.getIdJadwal(),
                j.getNamaKereta(),
                j.getTanggal(),
                j.getJam(),
                j.getAsal(), // Baru
                j.getTujuan(), // Baru
                j.getHarga(),
                j.getKursiTersedia()
            };
            tableModel.addRow(row);
        }
        lblTotalData.setText(" | Total: " + list.size() + " Data");
    }
}
