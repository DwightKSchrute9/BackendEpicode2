package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Rivista;
import util.JPAUtil;

public class RivistaDao {
	static Logger log = LoggerFactory.getLogger(RivistaDao.class);

    public static void add(Rivista rivista) {
    	EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(rivista);
			em.getTransaction().commit();
			System.out.println("Magazine added");
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    	
    }

    public static void remove(String isbn) {//da guardare
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
			em.getTransaction().begin();
			em.remove(isbn);
			em.getTransaction().commit();
			System.out.println("Magazine removed");
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    }

    public static Rivista findByIsbn(String isbn) {
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			Rivista rivista = em.find(Rivista.class, isbn);
			System.out.println("Magazine found: " + rivista.getIsbn());
			return rivista;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }

    public static List<Rivista> findByYear(int year){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Rivista> riviste = (List<Rivista>) em.find(Rivista.class, year);
    	try {
			em.getTransaction().begin();
			for(Rivista rivista : riviste) {
			System.out.println("Book found by year: " + rivista.getTitolo());
			}
			return riviste;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }

    public static List<Rivista> findByTitle(String title){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Rivista> riviste = (List<Rivista>) em.find(Rivista.class, title);
    	try {
			em.getTransaction().begin();
			for(Rivista rivista : riviste) {
			System.out.println("Book found by title: " + rivista.getTitolo());
			}
			return riviste;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    }


}
