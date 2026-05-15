package controllers;

import dao.UserDAO;
import models.User;

public class LoginController {

    // Instansiasi DAO
    UserDAO userDAO = new UserDAO();

    // Method INSERT User
    public void register(User user) {
        userDAO.register(user);
    }

    // Method Validasi Username
    public boolean checkUsername(String username) {
        return userDAO.checkUsername(username);
    }

    // Method Login
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}
