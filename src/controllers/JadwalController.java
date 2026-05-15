package controllers;

import dao.JadwalDAO;
import java.util.ArrayList;
import models.Jadwal;

public class JadwalController {

    // Instansiasi DAO
    JadwalDAO dao = new JadwalDAO();

    // Method INSERT Jadwal
    public void insert(Jadwal jadwal) {
        dao.insert(jadwal);
    }

    // Method SELECT Jadwal
    public ArrayList<Jadwal> getAll() {
        return dao.getAll();
    }

    // Method UPDATE Jadwal
    public void update(Jadwal jadwal) {
        dao.update(jadwal);
    }

    // Method DELETE Jadwal
    public void delete(int id) {
        dao.delete(id);
    }
}
