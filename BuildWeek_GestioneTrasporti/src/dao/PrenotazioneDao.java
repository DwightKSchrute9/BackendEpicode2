
package dao;

import java.util.List;

import model.Prenotazione;
import model.User;
import model.Viaggio;

public interface PrenotazioneDao {
  
  void saveOrUpdate(Prenotazione prenotazione);
  
  void delete(Prenotazione prenotazione);
  
  Prenotazione findById(Long id);
  
  List<Prenotazione> findAll();
  
  List<Prenotazione> findByUser(User user);
  
  List<Prenotazione> findByViaggio(Viaggio viaggio);
  
}
