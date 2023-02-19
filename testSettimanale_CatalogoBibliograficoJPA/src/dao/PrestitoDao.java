package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Prestito;
import util.JPAUtil;

public class PrestitoDao {
	static Logger log = LoggerFactory.getLogger(PrestitoDao.class);

    public static void add(Prestito prestito) {
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

    public static void remove(Prestito prestito) {
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

//    public Prestito findByItemAndUser(Utente utente, ElementoArchivio catalogoItem, Date dataInizioPrestito) {
//    	EntityManager em = JPAUtil.getEntityManager();
//    	try {
//			em.getTransaction().begin();
//	        this.utente = utente;
//	        this.catalogoItem = catalogoItem;
//	        this.dataInizioPrestito = dataInizioPrestito;
//	        Object[] array = null;
//	        array[1] = utente;
//	        array[2]= catalogoItem;
//	        array[3] = dataInizioPrestito;
//			return em.find(Prestito.class, array);
//		} finally {
//			em.close();
//		}
//    	
//    }

    //public List<Prestito> findByUser(int tessera);

    public static List<Prestito> findExpired(Date date){
    	EntityManager em = JPAUtil.getEntityManager();
    	@SuppressWarnings("unchecked")
		List<Prestito> prestiti = (List<Prestito>) em.find(Prestito.class, date);
    	try {
			em.getTransaction().begin();
			for(Prestito prestito : prestiti) {
				if (prestito.isScaduto()){
					System.out.println("Credit expired by date: " + prestito.toString());
				} else {
					return null;
				}
			}
			return prestiti;
    	} catch (Exception ec) {
			System.out.println(ec.getMessage());
		} finally {
			em.close();
		}
    	return null;
    	
    }

}
