
package dao;

import java.util.Date;
import java.util.List;
import model.CatalogoItem;
import model.Prestito;
import model.Utente;

public interface PrestitoDao {

    public void add(Prestito prestito);

    public void remove(Prestito prestito);

    public Prestito findByItemAndUser(CatalogoItem item, Utente utente);

    public List<Prestito> findByUser(int tessera);

    public List<Prestito> findExpired(Date date);

}
