package view.admin;

import controllers.JadwalController;
import controllers.KeretaController;
import exceptions.ValidationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Jadwal;
import models.Kereta;

// Inheritance
public class KelolaJadwal extends javax.swing.JFrame {

    // Constructor
    public KelolaJadwal() {
        initComponents();
        loadKereta();
        loadTable();
        txtId.setEnabled(false);
        setLocationRelativeTo(null);
        setTitle("Kelola Jadwal Kereta");
    }

    // Intansiasi Controller
    JadwalController controller = new JadwalController();
    KeretaController keretaController = new KeretaController();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        txtJam = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtKursi = new javax.swing.JTextField();
        cbKereta = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJadwal = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.addActionListener(this::txtIdActionPerformed);

        cbKereta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKereta.addActionListener(this::cbKeretaActionPerformed);

        tableJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Kereta", "Tanggal", "Jam", "Kursi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableJadwal.getTableHeader().setReorderingAllowed(false);
        tableJadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJadwal);
        if (tableJadwal.getColumnModel().getColumnCount() > 0) {
            tableJadwal.getColumnModel().getColumn(0).setResizable(false);
            tableJadwal.getColumnModel().getColumn(1).setResizable(false);
            tableJadwal.getColumnModel().getColumn(2).setResizable(false);
            tableJadwal.getColumnModel().getColumn(3).setResizable(false);
            tableJadwal.getColumnModel().getColumn(4).setResizable(false);
        }

        btnSimpan.setBackground(new java.awt.Color(51, 255, 51));
        btnSimpan.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(0, 0, 0));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnReset.setBackground(new java.awt.Color(255, 255, 51));
        btnReset.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(this::btnResetActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        jLabel1.setText("ID");

        jLabel2.setText("Nama Kereta");

        jLabel3.setText("Tanggal (YYYY-MM-DD)");

        jLabel4.setText("Jam (HH:MM:SS)");

        jLabel5.setText("Harga");

        jLabel6.setText("Kursi");

        btnKembali.setBackground(new java.awt.Color(255, 0, 0));
        btnKembali.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(this::btnKembaliActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKembali)
                            .addComponent(txtKursi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cbKereta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(157, 157, 157))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnSimpan)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnReset)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnUpdate)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnDelete))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(cbKereta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnReset)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
    }//GEN-LAST:event_txtIdActionPerformed

    // Event
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data terlebih dahulu");
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(txtId.getText());
            controller.delete(id);
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            loadTable();
            resetForm();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Event
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            if (txtTanggal.getText().isEmpty() || txtJam.getText().isEmpty() || txtHarga.getText().isEmpty() || txtKursi.getText().isEmpty()) {
                throw new ValidationException("Data jadwal wajib diisi!");
            } else {
                Jadwal jadwal = new Jadwal();
                String kereta = cbKereta.getSelectedItem().toString();
                int idKereta = Integer.parseInt(kereta.split(" - ")[0]);
                jadwal.setIdKereta(idKereta);
                jadwal.setTanggal(txtTanggal.getText());
                jadwal.setJam(txtJam.getText());
                jadwal.setHarga(Integer.parseInt(txtHarga.getText()));
                jadwal.setKursiTersedia(Integer.parseInt(txtKursi.getText()));
                controller.insert(jadwal);
                JOptionPane.showMessageDialog(this, "Jadwal Berhasil Ditambahkan");
                loadTable();
                resetForm();
            }
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Event
    private void cbKeretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKeretaActionPerformed
    }//GEN-LAST:event_cbKeretaActionPerformed

    // Event
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    // Event
    private void tableJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJadwalMouseClicked
        int row = tableJadwal.getSelectedRow();
        txtId.setText(tableJadwal.getValueAt(row, 0).toString());
        String namaKereta = tableJadwal.getValueAt(row, 1).toString();
        for (int i = 0; i < cbKereta.getItemCount(); i++) {
            String item = cbKereta.getItemAt(i);
            if (item.contains(namaKereta)) {
                cbKereta.setSelectedIndex(i);
                break;
            }
        }
        txtTanggal.setText(tableJadwal.getValueAt(row, 2).toString());
        txtJam.setText(tableJadwal.getValueAt(row, 3).toString());
        txtHarga.setText(tableJadwal.getValueAt(row, 4).toString());
        txtKursi.setText(tableJadwal.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableJadwalMouseClicked

    // Event
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (txtId.getText().isEmpty()) {
                throw new ValidationException("Data jadwal wajib diisi!");
            } else {
                Jadwal jadwal = new Jadwal();
                String kereta = cbKereta.getSelectedItem().toString();
                int idKereta = Integer.parseInt(kereta.split(" - ")[0]);
                jadwal.setIdJadwal(Integer.parseInt(txtId.getText()));
                jadwal.setIdKereta(idKereta);
                jadwal.setTanggal(txtTanggal.getText());
                jadwal.setJam(txtJam.getText());
                jadwal.setHarga(Integer.parseInt(txtHarga.getText()));
                jadwal.setKursiTersedia(Integer.parseInt(txtKursi.getText()));
                controller.update(jadwal);
                JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate");
                loadTable();
                resetForm();
            }
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Event
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Function Method
    private void resetForm() {
        txtId.setText("");
        txtTanggal.setText("");
        txtJam.setText("");
        txtHarga.setText("");
        txtKursi.setText("");
        if (cbKereta.getItemCount() > 0) {
            cbKereta.setSelectedIndex(0);
        }
        tableJadwal.clearSelection();
    }

    // Function Method
    private void loadKereta() {
        cbKereta.removeAllItems();
        ArrayList<Kereta> list = keretaController.getAll();
        for (Kereta k : list) {
            cbKereta.addItem(k.getIdKereta() + " - " + k.getNamaKereta());
        }
    }

    // Function Method
    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Kereta");
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        model.addColumn("Harga");
        model.addColumn("Kursi");
        ArrayList<Jadwal> list = controller.getAll();
        for (Jadwal j : list) {
            Object[] row = {
                j.getIdJadwal(),
                j.getNamaKereta(),
                j.getTanggal(),
                j.getJam(),
                j.getHarga(),
                j.getKursiTersedia()
            };
            model.addRow(row);
        }
        tableJadwal.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbKereta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableJadwal;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJam;
    private javax.swing.JTextField txtKursi;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
