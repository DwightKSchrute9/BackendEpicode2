package dao;

import java.util.List;
import model.Utente;

public interface UtenteDao {

    public void add(Utente utente);

    public void remove(int tessera);

    public Utente findByTessera(int tessera);

    public List<Utente> findAll();

}
