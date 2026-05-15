package view.admin;

import config.Session;
import javax.swing.JOptionPane;
import view.login.LoginForm;

// Inheritance
public class DashboardAdmin extends javax.swing.JFrame {

    // Constructor
    public DashboardAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Dashboard Admin");
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnKelolaKereta = new javax.swing.JButton();
        btnKelolaJadwal = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));

        lblTitle.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblTitle.setText("Dashboard Admin");

        btnKelolaKereta.setBackground(new java.awt.Color(51, 204, 255));
        btnKelolaKereta.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnKelolaKereta.setForeground(new java.awt.Color(255, 255, 255));
        btnKelolaKereta.setText("Kelola Kereta");
        btnKelolaKereta.addActionListener(this::btnKelolaKeretaActionPerformed);

        btnKelolaJadwal.setBackground(new java.awt.Color(51, 255, 255));
        btnKelolaJadwal.setFont(new java.awt.Font("Impact", 0, 12)); // NOI18N
        btnKelolaJadwal.setForeground(new java.awt.Color(255, 255, 255));
        btnKelolaJadwal.setText("Kelola Jadwal");
        btnKelolaJadwal.addActionListener(this::btnKelolaJadwalActionPerformed);

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setFont(new java.awt.Font("Impact", 0, 10)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(51, 51, 51));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKelolaKereta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKelolaJadwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnKelolaKereta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKelolaJadwal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Event
    private void btnKelolaKeretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaKeretaActionPerformed
        new KelolaKereta().setVisible(true);
    }//GEN-LAST:event_btnKelolaKeretaActionPerformed

    //Event
    private void btnKelolaJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKelolaJadwalActionPerformed
        new KelolaJadwal().setVisible(true);
    }//GEN-LAST:event_btnKelolaJadwalActionPerformed

    //Event
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            Session.clearSession();
            dispose();
            new LoginForm().setVisible(true);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKelolaJadwal;
    private javax.swing.JButton btnKelolaKereta;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
