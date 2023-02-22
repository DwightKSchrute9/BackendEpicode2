package dao;

import java.util.List;

import model.Stazione;

public interface StazioneDao {
  
  void saveOrUpdate(Stazione stazione);
  
  void delete(Stazione stazione);
  
  Stazione findById(Long id);
  
  List<Stazione> findAll();
}

