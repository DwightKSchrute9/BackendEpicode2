

package dao;

import java.util.List;
import model.Rivista;

public interface RivistaDao {

    public void add(Rivista rivista);

    public void remove(String isbn);

    public Rivista findByIsbn(String isbn);

    public List<Rivista> findByYear(int year);

    public List<Rivista> findByTitle(String title);

    public List<Rivista> findAll();

    public List<Rivista> findAvailable();

}
