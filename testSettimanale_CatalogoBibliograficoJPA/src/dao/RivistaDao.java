package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Rivista;
import util.JPAUtil;

public class RivistaDao {
	static Logger log = LoggerFactory.getLogger(RivistaDao.class);

    public void add(Rivista rivista) {
    	EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(rivista);
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

    public Rivista findByIsbn(String isbn) {
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return em.find(Rivista.class, isbn);
		} finally {
			em.close();
		}
    }

    public List<Rivista> findByYear(int year){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Rivista>) em.find(Rivista.class, year);
		} finally {
			em.close();
		}
    }

    public List<Rivista> findByTitle(String title){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Rivista>) em.find(Rivista.class, title);
		} finally {
			em.close();
		}
    }

    //public List<Rivista> findAll();

    //public List<Rivista> findAvailable(){
    	
    

}
