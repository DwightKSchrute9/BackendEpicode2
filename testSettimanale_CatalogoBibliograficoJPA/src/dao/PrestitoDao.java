package dao;

import java.lang.reflect.Array;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.ElementoCatalogo;
import model.Libro;
import model.Prestito;
import model.Utente;
import util.JPAUtil;

public class PrestitoDao {
	static Logger log = LoggerFactory.getLogger(PrestitoDao.class);
	private Utente utente;
	private ElementoCatalogo catalogoItem;
	private Date dataInizioPrestito;

    public void add(Prestito prestito) {
    	EntityManager em = JPAUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(prestito);
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    	
    }

    public void remove(Prestito prestito) {
    	EntityManager em = JPAUtil.getEntityManager();
    	
    	try {
			em.getTransaction().begin();
			em.remove(prestito);
			em.getTransaction().commit();
		} catch (Exception ec) {
			em.getTransaction().rollback();
			log.error(ec.getMessage());
		} finally {
			em.close();
		}
    }

    public Prestito findByItemAndUser(Utente utente, ElementoCatalogo catalogoItem, Date dataInizioPrestito) {
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
	        this.utente = utente;
	        this.catalogoItem = catalogoItem;
	        this.dataInizioPrestito = dataInizioPrestito;
	        Object[] array = null;
	        array[1] = utente;
	        array[2]= catalogoItem;
	        array[3] = dataInizioPrestito;
			return em.find(Prestito.class, array);
		} finally {
			em.close();
		}
    	
    }

    //public List<Prestito> findByUser(int tessera);

    public List<Prestito> findExpired(Date date){
    	EntityManager em = JPAUtil.getEntityManager();
    	try {
			em.getTransaction().begin();
			return (List<Prestito>) em.find(Prestito.class, date);
		} finally {
			em.close();
		}
    	
    }

}
