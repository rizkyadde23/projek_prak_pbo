package view.user;

import config.Session;
import controllers.JadwalController;
import controllers.PemesananController;
import exceptions.TiketException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Jadwal;
import models.Pemesanan;

// Inheritance
public class PesanTiket extends javax.swing.JFrame {

    // Constructor
    public PesanTiket() {
        initComponents();
        loadTable();
        txtIdJadwal.setEnabled(false);
        setLocationRelativeTo(null);
        txtHarga.setEnabled(false);
        txtKursi.setEnabled(false);
        txtTotal.setEnabled(false);
        setTitle("Pesan Tiket");
    }

    // Instansiasi Controller
    JadwalController jadwalController = new JadwalController();
    PemesananController pemesananController = new PemesananController();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJadwal = new javax.swing.JTable();
        txtIdJadwal = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtKursi = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnPesan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableJadwal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kereta", "Tanggal", "Jam", "Harga", "Kursi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            tableJadwal.getColumnModel().getColumn(5).setResizable(false);
        }

        txtIdJadwal.addActionListener(this::txtIdJadwalActionPerformed);

        txtHarga.addActionListener(this::txtHargaActionPerformed);

        txtJumlah.addActionListener(this::txtJumlahActionPerformed);

        txtTotal.addActionListener(this::txtTotalActionPerformed);

        jLabel1.setText("Jadwal");

        jLabel2.setText("Harga");

        jLabel3.setText("Kursi");

        jLabel4.setText("Jumlah");

        jLabel5.setText("Total");

        btnHitung.setBackground(new java.awt.Color(255, 255, 0));
        btnHitung.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnHitung.setForeground(new java.awt.Color(0, 0, 0));
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(this::btnHitungActionPerformed);

        btnPesan.setBackground(new java.awt.Color(0, 255, 0));
        btnPesan.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnPesan.setForeground(new java.awt.Color(0, 0, 0));
        btnPesan.setText("Pesan");
        btnPesan.addActionListener(this::btnPesanActionPerformed);

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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKembali)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(txtIdJadwal)
                                .addComponent(txtHarga)
                                .addComponent(txtKursi)
                                .addComponent(txtJumlah)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(385, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHitung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesan))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnPesan))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event
    private void txtIdJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdJadwalActionPerformed
    }//GEN-LAST:event_txtIdJadwalActionPerformed

    // Event
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
    }//GEN-LAST:event_txtTotalActionPerformed

    // Event
    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
    }//GEN-LAST:event_txtHargaActionPerformed

    // Event
    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
    }//GEN-LAST:event_txtJumlahActionPerformed

    // Event
    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        try {
            int harga = Integer.parseInt(txtHarga.getText());
            int jumlah = Integer.parseInt(txtJumlah.getText());
            int total = harga * jumlah;
            txtTotal.setText(String.valueOf(total));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid");
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    // Event
    private void tableJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJadwalMouseClicked
        int row = tableJadwal.getSelectedRow();
        txtIdJadwal.setText(tableJadwal.getValueAt(row, 0).toString());
        txtHarga.setText(tableJadwal.getValueAt(row, 4).toString());
        txtKursi.setText(tableJadwal.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tableJadwalMouseClicked

    // Event
    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        try {
            int idJadwal = Integer.parseInt(txtIdJadwal.getText());
            int kursi = Integer.parseInt(txtKursi.getText());
            int jumlah = Integer.parseInt(txtJumlah.getText());
            int total = Integer.parseInt(txtTotal.getText());
            try {
                if (jumlah <= 0) {
                    throw new TiketException("Jumlah tiket tidak valid!");
                }
                if (jumlah > kursi) {
                    throw new TiketException("Kursi tidak mencukupi!");
                }
            } catch (TiketException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            Pemesanan p = new Pemesanan();
            p.setIdUser(Session.idUser);
            p.setIdJadwal(idJadwal);
            p.setJumlahTiket(jumlah);
            p.setTotalHarga(total);
            pemesananController.insert(p);
            int sisa = kursi - jumlah;
            pemesananController.updateKursi(idJadwal, sisa);
            JOptionPane.showMessageDialog(this, "Pemesanan Berhasil");
            loadTable();
            resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan");
            System.out.println(e);
        }
    }//GEN-LAST:event_btnPesanActionPerformed

    // Event
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        dispose();
        new DashboardUser().setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    // Function Method
    private void resetForm() {
        txtIdJadwal.setText("");
        txtHarga.setText("");
        txtKursi.setText("");
        txtJumlah.setText("");
        txtTotal.setText("");
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
        ArrayList<Jadwal> list = jadwalController.getAll();
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
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableJadwal;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKursi;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
