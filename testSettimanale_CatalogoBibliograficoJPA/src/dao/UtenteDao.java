package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Libro;
import model.Utente;
import util.JPAUtil;

public class UtenteDao {
	static Logger log = LoggerFactory.getLogger(UtenteDao.class);


    public void add(Utente utente) {
    	EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(utente);
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    	
    }

    public void remove(int tessera) {
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
			em.getTransaction().begin();
			em.remove(tessera);
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    	
    }

    public Utente findByTessera(int tessera){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return em.find(Utente.class, tessera);
		} finally {
			em.close();
		}
    	
    }
    //public List<Utente> findAll();

}
