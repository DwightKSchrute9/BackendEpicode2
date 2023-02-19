package dao;

import java.util.List;
import model.ElementoCatalogo;

public abstract class ElementoCatalogoDao {
    
    public abstract void add(ElementoCatalogo item);
    
    public abstract void remove(String isbn);
    
    public abstract ElementoCatalogo findByIsbn(String isbn);
    
    public abstract List<ElementoCatalogo> findByYear(int year);
    
    public abstract List<ElementoCatalogo> findByAuthor(String author);
    
    public abstract List<ElementoCatalogo> findByTitle(String title);
    
}
