
package dao;

import java.util.List;

import model.Mezzo;

public interface MezzoDao {

  Mezzo findById(Long id);

  List<Mezzo> findAll();

  void save(Mezzo mezzo);

  void update(Mezzo mezzo);

  void delete(Mezzo mezzo);

  void deleteById(Long id);
}
