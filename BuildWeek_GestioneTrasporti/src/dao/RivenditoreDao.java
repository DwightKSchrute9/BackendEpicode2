
package dao;

import model.Rivenditore;

import java.util.List;

public interface RivenditoreDao {
    Rivenditore findById(Long id);
    List<Rivenditore> findAll();
    void save(Rivenditore rivenditore);
    void update(Rivenditore rivenditore);
    void delete(Rivenditore rivenditore);
    void deleteById(Long id);
}
