package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Libro;
import util.JPAUtil;

public class LibroDao {
	
	static Logger log = LoggerFactory.getLogger(LibroDao.class);

	public void add(Libro libro) {
			EntityManager em = JPAUtil.getEntityManager();
			
			try {
				em.getTransaction().begin();
				em.persist(libro);
				em.getTransaction().commit();
			} catch (Exception ec) {
				em.getTransaction().rollback();
				log.error(ec.getMessage());
			} finally {
				em.close();
			}
		}

	
    
    public void remove(String isbn) {
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
			em.getTransaction().begin();
			em.remove(isbn);
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    }

    public Libro findByIsbn(String isbn) {
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return em.find(Libro.class, isbn);
		} finally {
			em.close();
		}
    }
    

    public List<Libro> findByYear(int year){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Libro>) em.find(Libro.class, year);
		} finally {
			em.close();
		}
    }

    public List<Libro> findByAuthor(String author){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Libro>) em.find(Libro.class, author);
		} finally {
			em.close();
		}
    }

    public List<Libro> findByTitle(String title){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Libro>) em.find(Libro.class, title);
		} finally {
			em.close();
		}
    }

    //public List<Libro> findAll();

    //public List<Libro> findAvailable();

}
