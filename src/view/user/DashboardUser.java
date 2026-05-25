package view.user;

import config.Session;
import javax.swing.JOptionPane;
import view.login.LoginForm;

// Inheritance
public class DashboardUser extends javax.swing.JFrame {

    // Constructor
    public DashboardUser() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Dashboard User");
        setResizable(false);
        lblUser.setText("Selamat Datang, " + Session.nama);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnPesanTiket = new javax.swing.JButton();
        btnRiwayat = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTitle.setText("Dashboard User");

        lblUser.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        lblUser.setText("Selamat Datang");

        btnPesanTiket.setBackground(new java.awt.Color(0, 153, 255));
        btnPesanTiket.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnPesanTiket.setForeground(new java.awt.Color(255, 255, 255));
        btnPesanTiket.setText("Pesan Tiket");
        btnPesanTiket.addActionListener(this::btnPesanTiketActionPerformed);

        btnRiwayat.setBackground(new java.awt.Color(51, 255, 255));
        btnRiwayat.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnRiwayat.setForeground(new java.awt.Color(255, 255, 255));
        btnRiwayat.setText("Riwayat");
        btnRiwayat.addActionListener(this::btnRiwayatActionPerformed);

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnPesanTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblTitle))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUser)
                .addGap(31, 31, 31)
                .addComponent(btnPesanTiket, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Event
    private void btnPesanTiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanTiketActionPerformed
        new PesanTiket().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPesanTiketActionPerformed

    // Event
    private void btnRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatActionPerformed
        new RiwayatPemesanan().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRiwayatActionPerformed

    // Event
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Session.clearSession();
            new LoginForm().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPesanTiket;
    private javax.swing.JButton btnRiwayat;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
