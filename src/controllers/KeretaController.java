package controllers;

import dao.KeretaDAO;
import exceptions.ValidationException;
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

    public void tambahKereta(
            String nama
    ) throws Exception {

        if (nama.isEmpty()) {
            throw new ValidationException(
                    "Semua data wajib diisi!");
        }
        Kereta kereta = new Kereta();
        kereta.setNamaKereta(nama);
        insert(kereta);
    }

    public void updateKereta(
            String id,
            String nama
    ) throws Exception {
        if (id.isEmpty()) {
            throw new ValidationException(
                    "Pilih data terlebih dahulu!");
        }
        if (nama.isEmpty()) {
            throw new ValidationException(
                    "Semua data wajib diisi!");
        }
        Kereta kereta = new Kereta();
        kereta.setIdKereta(
                Integer.parseInt(id));
        kereta.setNamaKereta(nama);
        update(kereta);
    }

    public void hapusKereta(String id)
            throws Exception {
        if (id.isEmpty()) {
            throw new ValidationException(
                    "Pilih data terlebih dahulu!");
        }
        delete(Integer.parseInt(id));
    }
}
