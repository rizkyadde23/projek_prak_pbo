package controllers;

import config.Session;
import dao.UserDAO;
import exceptions.LoginException;
import exceptions.RegisterException;
import models.AbstractUser;
import models.Admin;
import models.Customer;
import models.User;

public class LoginController {

    // Instansiasi DAO
    UserDAO userDAO = new UserDAO();

    // Method INSERT User
    public void registerUser(User user) {
        userDAO.register(user);
    }

    // Method Validasi Username
    public boolean checkUsername(String username) {
        return userDAO.checkUsername(username);
    }

    // Method Login
    public User loginUser(String username, String password) {
        return userDAO.login(username, password);
    }

    public AbstractUser login(
            String username,
            String password
    ) throws LoginException {

        validateLogin(username, password);

        User user = this.loginUser(username, password);

        if (user == null) {
            throw new LoginException(
                    "Username atau Password salah!"
            );
        }

        setSession(user);

        AbstractUser userAccess = getUserAccess(user);

        userAccess.setNama(user.getNama());

        return userAccess;
    }

    private void validateLogin(String username, String password) throws LoginException {
        if (username.isEmpty() || password.isEmpty()) {
            throw new LoginException("Username dan Password wajib diisi!");
        }
    }

    private void setSession(User user) {
        Session.idUser = user.getIdUser();
        Session.nama = user.getNama();
        Session.role = user.getRole();
    }

    private AbstractUser getUserAccess(User user) {
        if (user.getRole().equals("admin")) {
            return new Admin();
        }
        return new Customer();
    }

    public void register(
            String nama,
            String username,
            String password
    ) throws RegisterException {

        validateRegister(
                nama,
                username,
                password
        );

        // CHECK USERNAME
        if (this.checkUsername(username)) {

            throw new RegisterException(
                    "Username sudah digunakan!"
            );
        }

        // OBJECT USER
        User user = new User();

        user.setNama(nama);
        user.setUsername(username);
        user.setPassword(password);

        // INSERT DATABASE
        this.registerUser(user);
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
