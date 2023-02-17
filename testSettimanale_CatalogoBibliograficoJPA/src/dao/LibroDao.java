
package dao;

import model.Libro;

public interface LibroDao<Libro> {

    public void add(Libro libro);

    public void remove(String isbn);

    public Libro findByIsbn(String isbn);

    public List<Libro> findByYear(int year);

    public List<Libro> findByAuthor(String author);

    public List<Libro> findByTitle(String title);

    public List<Libro> findAll();

    public List<Libro> findAvailable();

}
