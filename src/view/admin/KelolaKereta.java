package view.admin;

import controllers.KeretaController;
import exceptions.ValidationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Kereta;

// Inheritance
public class KelolaKereta extends javax.swing.JFrame {

    // Constructor
    public KelolaKereta() {
        initComponents();
        loadTable();
        txtId.setEnabled(false);
        setLocationRelativeTo(null);
        setTitle("Kelola Kereta");
    }

    // Instansiasi Controller
    KeretaController controller = new KeretaController();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAsal = new javax.swing.JTextField();
        txtTujuan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKereta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.addActionListener(this::txtIdActionPerformed);

        txtAsal.addActionListener(this::txtAsalActionPerformed);

        btnSimpan.setBackground(new java.awt.Color(0, 255, 0));
        btnSimpan.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(0, 0, 0));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 0));
        btnUpdate.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(0, 0, 0));
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnReset.setBackground(new java.awt.Color(255, 255, 0));
        btnReset.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Reset");
        btnReset.addActionListener(this::btnResetActionPerformed);

        tableKereta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Asal", "Tujuan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKereta.getTableHeader().setReorderingAllowed(false);
        tableKereta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKeretaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKereta);
        if (tableKereta.getColumnModel().getColumnCount() > 0) {
            tableKereta.getColumnModel().getColumn(0).setResizable(false);
            tableKereta.getColumnModel().getColumn(1).setResizable(false);
            tableKereta.getColumnModel().getColumn(2).setResizable(false);
            tableKereta.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("ID");

        jLabel2.setText("Masukkan Nama Kereta");

        jLabel3.setText("Masukkan Asal");

        jLabel4.setText("Masukkan Tujuan");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAsal)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(txtNama)
                                .addComponent(jLabel1)
                                .addComponent(txtId)
                                .addComponent(jLabel2)
                                .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnKembali))
                        .addGap(0, 216, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnReset)
                    .addComponent(btnUpdate)
                    .addComponent(btnHapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event
    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
    }//GEN-LAST:event_txtIdActionPerformed

    // Event
    private void txtAsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsalActionPerformed
    }//GEN-LAST:event_txtAsalActionPerformed

    // Event
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            if (txtNama.getText().isEmpty() || txtAsal.getText().isEmpty() || txtTujuan.getText().isEmpty()) {
                throw new ValidationException("Data kereta wajib diisi!");
            } else {
                Kereta kereta = new Kereta();
                kereta.setNamaKereta(txtNama.getText());
                kereta.setAsal(txtAsal.getText());
                kereta.setTujuan(txtTujuan.getText());
                controller.insert(kereta);
                JOptionPane.showMessageDialog(this, "Data Berhasil Ditambahkan");
                loadTable();
                resetForm();
            }
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    // Event
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed

    // Event
    private void tableKeretaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKeretaMouseClicked
        int row = tableKereta.getSelectedRow();
        txtId.setText(tableKereta.getValueAt(row, 0).toString());
        txtNama.setText(tableKereta.getValueAt(row, 1).toString());
        txtAsal.setText(tableKereta.getValueAt(row, 2).toString());
        txtTujuan.setText(tableKereta.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tableKeretaMouseClicked

    // Event
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (txtNama.getText().isEmpty() || txtAsal.getText().isEmpty() || txtTujuan.getText().isEmpty()) {
                throw new ValidationException("Data kereta wajib diisi!");
            } else {
                Kereta kereta = new Kereta();
                kereta.setIdKereta(Integer.parseInt(txtId.getText()));
                kereta.setNamaKereta(txtNama.getText());
                kereta.setAsal(txtAsal.getText());
                kereta.setTujuan(txtTujuan.getText());
                controller.update(kereta);
                JOptionPane.showMessageDialog(this, "Data Berhasil Diupdate");
                loadTable();
                resetForm();
            }
        } catch (ValidationException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Event
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int id = Integer.parseInt(txtId.getText());
        controller.delete(id);
        JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        loadTable();
        resetForm();
    }//GEN-LAST:event_btnHapusActionPerformed

    // Event
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new DashboardAdmin().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Function Method
    private void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtAsal.setText("");
        txtTujuan.setText("");
    }

    // Function Method
    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Kereta");
        model.addColumn("Asal");
        model.addColumn("Tujuan");
        ArrayList<Kereta> list = controller.getAll();
        for (Kereta k : list) {
            Object[] row = {
                k.getIdKereta(),
                k.getNamaKereta(),
                k.getAsal(),
                k.getTujuan()
            };
            model.addRow(row);
        }
        tableKereta.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKereta;
    private javax.swing.JTextField txtAsal;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTujuan;
    // End of variables declaration//GEN-END:variables
}
