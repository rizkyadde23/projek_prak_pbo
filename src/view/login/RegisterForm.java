package view.login;

import controllers.LoginController;
import exceptions.RegisterException;
import java.awt.*;
import javax.swing.*;
import models.User;

public class RegisterForm extends JFrame {

    private final LoginController controller = new LoginController();

    private JTextField txtNama;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    private JButton btnRegister;
    private JButton btnLogin;

    public RegisterForm() {
        initComponents();
        setTitle("REGISTER E-TIKET");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // ROOT PANEL
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(15, 23, 42));

        // CENTER PANEL (Untuk memusatkan card di tengah layar)
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(15, 23, 42));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // CARD PANEL
        JPanel card = new JPanel();
        Dimension cardSize = new Dimension(450, 600); // Diperbesar sedikit karena ada 3 inputan
        card.setPreferredSize(cardSize);
        card.setMaximumSize(cardSize);
        card.setMinimumSize(cardSize);
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(40, 50, 40, 50)
        ));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TITLE
        JLabel title = new JLabel("REGISTER E-TIKET", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(30, 41, 59));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // SUBTITLE
        JLabel subtitle = new JLabel("Buat akun baru", SwingConstants.CENTER);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- FORM PANEL ---
        // Membungkus label dan field agar rata kiri secara presisi
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(Color.WHITE);
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension fieldSize = new Dimension(350, 40);

        // LABEL & TEXT NAMA
        JLabel lblNama = new JLabel("Nama Lengkap");
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNama.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtNama = new JTextField();
        txtNama.setPreferredSize(fieldSize);
        txtNama.setMaximumSize(fieldSize);
        txtNama.setMinimumSize(fieldSize);
        txtNama.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtNama.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtNama.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        // LABEL & TEXT USERNAME
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUsername.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtUsername = new JTextField();
        txtUsername.setPreferredSize(fieldSize);
        txtUsername.setMaximumSize(fieldSize);
        txtUsername.setMinimumSize(fieldSize);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtUsername.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        // LABEL & TEXT PASSWORD
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(fieldSize);
        txtPassword.setMaximumSize(fieldSize);
        txtPassword.setMinimumSize(fieldSize);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        // Susun komponen ke dalam Form Panel
        formPanel.add(lblNama);
        formPanel.add(Box.createVerticalStrut(8));
        formPanel.add(txtNama);
        formPanel.add(Box.createVerticalStrut(20));

        formPanel.add(lblUsername);
        formPanel.add(Box.createVerticalStrut(8));
        formPanel.add(txtUsername);
        formPanel.add(Box.createVerticalStrut(20));

        formPanel.add(lblPassword);
        formPanel.add(Box.createVerticalStrut(8));
        formPanel.add(txtPassword);

        // --- BUTTONS ---
        Dimension buttonSize = new Dimension(350, 45);

        btnRegister = new JButton("REGISTER");
        btnRegister.setPreferredSize(buttonSize);
        btnRegister.setMaximumSize(buttonSize);
        btnRegister.setMinimumSize(buttonSize);
        btnRegister.setBackground(new Color(37, 99, 235));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegister.addActionListener(e -> register());

        btnLogin = new JButton("LOGIN");
        btnLogin.setPreferredSize(buttonSize);
        btnLogin.setMaximumSize(buttonSize);
        btnLogin.setMinimumSize(buttonSize);
        btnLogin.setBackground(new Color(234, 88, 12));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.addActionListener(e -> {
            new LoginForm().setVisible(true);
            dispose();
        });

        // --- SUSUN SEMUA KOMPONEN KE DALAM CARD ---
        card.add(Box.createVerticalStrut(10));
        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(35));

        card.add(formPanel); // Memasukkan sub-panel

        card.add(Box.createVerticalStrut(35));
        card.add(btnRegister);
        card.add(Box.createVerticalStrut(15));
        card.add(btnLogin);
        card.add(Box.createVerticalStrut(10));

        // CENTER POSITION
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(card);
        centerPanel.add(Box.createVerticalGlue());

        root.add(centerPanel, BorderLayout.CENTER);
        add(root);
    }

    private void register() {
        try {
            String nama = txtNama.getText();
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            validateRegister(nama, username, password);

            if (controller.checkUsername(username)) {
                throw new RegisterException("Username sudah digunakan!");
            }

            User user = new User();
            user.setNama(nama);
            user.setUsername(username);
            user.setPassword(password);

            controller.register(user);

            JOptionPane.showMessageDialog(this, "Register berhasil!");

            new LoginForm().setVisible(true);
            dispose();

        } catch (RegisterException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void validateRegister(String nama, String username, String password) throws RegisterException {
        if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
            throw new RegisterException("Semua field wajib diisi!");
        }

        if (password.length() < 4) {
            throw new RegisterException("Password minimal 4 karakter!");
        }
    }
}
