package controllers;

import dao.KeretaDAO;
import java.util.ArrayList;
import models.Kereta;

public class KeretaController {

    // Instansiasi DAO
    KeretaDAO dao = new KeretaDAO();

    // Method INSERT Kereta
    public void insert(Kereta kereta) {
        dao.insert(kereta);
    }

    // Method SELECT Kereta
    public ArrayList<Kereta> getAll() {
        return dao.getAll();
    }

    // Method Update Kereta
    public void update(Kereta kereta) {
        dao.update(kereta);
    }

    // Method Delete Kereta
    public void delete(int id) {
        dao.delete(id);
    }
}
