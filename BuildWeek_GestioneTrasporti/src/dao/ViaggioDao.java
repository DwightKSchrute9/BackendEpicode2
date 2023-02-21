package dao;

import java.util.List;

import model.Viaggio;

public interface ViaggioDao {
    Viaggio save(Viaggio viaggio);
    Viaggio update(Viaggio viaggio);
    void delete(Viaggio viaggio);
    Viaggio findById(Long id);
    List<Viaggio> findAll();
}
