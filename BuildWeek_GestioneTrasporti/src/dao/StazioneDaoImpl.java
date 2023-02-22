package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Stazione;

public class StazioneDaoImpl implements StazioneDao {

  private EntityManagerFactory emf;

  public StazioneDaoImpl() {
    this.emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");
  }

  @Override
  public void saveOrUpdate(Stazione stazione) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.merge(stazione);
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public void delete(Stazione stazione) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
      tx.begin();
      em.remove(em.contains(stazione) ? stazione : em.merge(stazione));
      tx.commit();
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.close();
    }
  }

  @Override
  public Stazione findById(Long id) {
    EntityManager em = emf.createEntityManager();
    Stazione stazione = em.find(Stazione.class, id);
    em.close();
    return stazione;
  }

  @Override
  public List<Stazione> findAll() {
    EntityManager em = emf.createEntityManager();
    TypedQuery<Stazione> query = em.createQuery("SELECT s FROM Stazione s", Stazione.class);
    List<Stazione> stazioni = query.getResultList();
    em.close();
    return stazioni;
  }

}

