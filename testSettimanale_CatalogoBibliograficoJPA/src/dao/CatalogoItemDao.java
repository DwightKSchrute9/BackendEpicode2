
package dao;

import java.util.List;
import model.CatalogoItem;

public abstract class CatalogoItemDao {
    
    public abstract void add(CatalogoItem item);
    
    public abstract void remove(String isbn);
    
    public abstract CatalogoItem findByIsbn(String isbn);
    
    public abstract List<CatalogoItem> findByYear(int year);
    
    public abstract List<CatalogoItem> findByAuthor(String author);
    
    public abstract List<CatalogoItem> findByTitle(String title);
    
}
