
package dao;

import java.util.List;

import model.Tessera;

public interface TesseraDao {
    
    Tessera findById(Long id);
    
    List<Tessera> findAll();
    
    void save(Tessera tessera);
    
    void update(Tessera tessera);
    
    void delete(Tessera tessera);
    
    void deleteById(Long id);
    
}
