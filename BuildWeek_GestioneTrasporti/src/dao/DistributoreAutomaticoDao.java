

package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.DistributoreAutomatico;

public class DistributoreAutomaticoDao {

    private EntityManagerFactory emf;

    public DistributoreAutomaticoDao() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void create(DistributoreAutomatico distributoreAutomatico) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(distributoreAutomatico);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public DistributoreAutomatico findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(DistributoreAutomatico.class, id);
        } finally {
            em.close();
        }
    }

    public void update(DistributoreAutomatico distributoreAutomatico) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(distributoreAutomatico);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void delete(DistributoreAutomatico distributoreAutomatico) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(distributoreAutomatico) ? distributoreAutomatico : em.merge(distributoreAutomatico));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}
