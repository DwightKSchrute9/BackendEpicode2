package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Libro;
import util.JPAUtil;

public class LibroDao {
	
	static Logger log = LoggerFactory.getLogger(LibroDao.class);

	public static void add(Libro libro) {
			EntityManager em = JPAUtil.getEntityManager();
			
			try {
				em.getTransaction().begin();
				em.persist(libro);
				em.getTransaction().commit();
				System.out.println("Book added");
			} catch (Exception ec) {
				em.getTransaction().rollback();
				log.error(ec.getMessage());
			} finally {
				em.close();
			}
		}
	
    
    public static void remove(String isbn) { //da guardare
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
			em.getTransaction().begin();
			em.remove(isbn);
			em.getTransaction().commit();
			System.out.println("Book removed");
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    }

    public static Libro findByIsbn(String isbn) {
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			Libro libro = em.find(Libro.class, isbn);
			System.out.println("Book found: " + libro.getIsbn());
			return libro;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }
    

    public static List<Libro> findByYear(int year){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Libro> libri = (List<Libro>) em.find(Libro.class, year);
    	try {
			em.getTransaction().begin();
			for(Libro libro : libri) {
			System.out.println("Book found by year: " + libro.getTitolo());
			}
			return libri;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }

    public static List<Libro> findByAuthor(String author){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Libro> libri = (List<Libro>) em.find(Libro.class, author);
    	try {
			em.getTransaction().begin();
			for(Libro libro : libri) {
				System.out.println("Book found by author: " + libro.getTitolo());
				}
				return libri;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }

    public static List<Libro> findByTitle(String title){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Libro> libri = (List<Libro>) em.find(Libro.class, title);
    	try {
			em.getTransaction().begin();
			for(Libro libro : libri) {
				System.out.println("Book found by title: " + libro.getTitolo());
				}
				return libri;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }

}
