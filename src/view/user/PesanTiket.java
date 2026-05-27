package view.user;

import controllers.JadwalController;
import exceptions.TiketException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Jadwal;

// Inheritance
public class PesanTiket extends javax.swing.JFrame {

    private final ArrayList<Jadwal> jadwalList
            = new ArrayList<>();

    // Constructor
    public PesanTiket() {
        initComponents();
        loadTable();
        txtIdJadwal.setEnabled(false);
        setLocationRelativeTo(null);
        txtHarga.setEnabled(false);
        txtKursi.setEnabled(false);
        setTitle("Pesan Tiket");
    }

    // Instansiasi Controller
    JadwalController jadwalController = new JadwalController();

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
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

        jLabel1.setText("Jadwal");

        jLabel2.setText("Harga");

        jLabel3.setText("Kursi");

        jLabel4.setText("Jumlah");

        btnHitung.setBackground(new java.awt.Color(255, 255, 0));
        btnHitung.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnHitung.setForeground(new java.awt.Color(0, 0, 0));
        btnHitung.setText("Checkout");
        btnHitung.addActionListener(this::btnHitungActionPerformed);

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
                                .addComponent(txtIdJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(txtHarga)
                                .addComponent(txtKursi)
                                .addComponent(txtJumlah)))
                        .addContainerGap(385, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231))
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
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event
    private void txtIdJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdJadwalActionPerformed
    }//GEN-LAST:event_txtIdJadwalActionPerformed

    // Event
    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
    }//GEN-LAST:event_txtHargaActionPerformed

    // Event
    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
    }//GEN-LAST:event_txtJumlahActionPerformed

    // Event
    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed

        try {

            Jadwal jadwal
                    = getSelectedJadwal();

            if (jadwal == null) {

                throw new TiketException(
                        "Pilih jadwal terlebih dahulu!");
            }

            int jumlah
                    = Integer.parseInt(
                            txtJumlah.getText());

            if (jumlah <= 0) {

                throw new TiketException(
                        "Jumlah tiket tidak valid!");
            }

            if (jumlah
                    > jadwal.getKursiTersedia()) {

                throw new TiketException(
                        "Kursi tidak mencukupi!");
            }

            int total
                    = hitungTotal(
                            jumlah,
                            jadwal.getHarga());

            // BUKA CHECKOUT
            new CheckoutForm(
                    jadwal,
                    jumlah,
                    total
            ).setVisible(true);
            dispose();

        } catch (TiketException e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Jumlah tiket harus angka!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage());
        }

    }//GEN-LAST:event_btnHitungActionPerformed

    // Event
    private void tableJadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJadwalMouseClicked

        Jadwal jadwal
                = getSelectedJadwal();

        if (jadwal != null) {

            txtIdJadwal.setText(
                    String.valueOf(
                            jadwal.getIdJadwal()));

            txtHarga.setText(
                    String.valueOf(
                            jadwal.getHarga()));

            txtKursi.setText(
                    String.valueOf(
                            jadwal.getKursiTersedia()));
        }

    }//GEN-LAST:event_tableJadwalMouseClicked

    // Event
    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        new DashboardUser().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private int hitungTotal(
            int jumlah,
            int harga
    ) {

        return jumlah * harga;
    }

    private Jadwal getSelectedJadwal() {

        int selectedRow
                = tableJadwal.getSelectedRow();

        if (selectedRow == -1) {

            return null;
        }

        return jadwalList.get(selectedRow);
    }

    // Function Method
    private void loadTable() {

        DefaultTableModel model
                = (DefaultTableModel) tableJadwal.getModel();

        model.setRowCount(0);

        jadwalList.clear();

        ArrayList<Jadwal> list
                = jadwalController.getAll();

        for (Jadwal j : list) {

            // SIMPAN OBJECT
            jadwalList.add(j);

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableJadwal;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdJadwal;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKursi;
    // End of variables declaration//GEN-END:variables
}
