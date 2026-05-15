package view.user;

import config.Session;
import controllers.PemesananController;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Pemesanan;

// Inheritance
public class RiwayatPemesanan extends javax.swing.JFrame {

    // Constructor
    public RiwayatPemesanan() {
        initComponents();
        loadTable();
        setLocationRelativeTo(null);
        setTitle("Riwayat Pemesanan Tiket");
    }

    // Intansiasi Controller
    PemesananController controller = new PemesananController();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRiwayat = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Pemesanan", "Nama Kereta", "Tanggal", "Jam", "Jumlah Pesanan", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRiwayat.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableRiwayat);
        if (tableRiwayat.getColumnModel().getColumnCount() > 0) {
            tableRiwayat.getColumnModel().getColumn(0).setResizable(false);
            tableRiwayat.getColumnModel().getColumn(1).setResizable(false);
            tableRiwayat.getColumnModel().getColumn(2).setResizable(false);
            tableRiwayat.getColumnModel().getColumn(3).setResizable(false);
            tableRiwayat.getColumnModel().getColumn(4).setResizable(false);
            tableRiwayat.getColumnModel().getColumn(5).setResizable(false);
        }

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali)
                        .addGap(0, 412, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
        new DashboardUser().setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Function Method
    private void loadTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Kereta");
        model.addColumn("Tanggal");
        model.addColumn("Jam");
        model.addColumn("Jumlah");
        model.addColumn("Total");
        ArrayList<Pemesanan> list = controller.getRiwayat(Session.idUser);
        for (Pemesanan p : list) {
            Object[] row = {
                p.getIdPemesanan(),
                p.getNamaKereta(),
                p.getTanggal(),
                p.getJam(),
                p.getJumlahTiket(),
                p.getTotalHarga()
            };
            model.addRow(row);
        }
        tableRiwayat.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRiwayat;
    // End of variables declaration//GEN-END:variables
}
