package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Rivenditore;

import java.util.List;

public class RivenditoreDaoImpl implements RivenditoreDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    @Override
    public Rivenditore findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Rivenditore rivenditore = em.find(Rivenditore.class, id);
        em.close();
        return rivenditore;
    }

    @Override
    public List<Rivenditore> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Rivenditore> query = em.createQuery("SELECT r FROM Rivenditore r", Rivenditore.class);
        List<Rivenditore> rivenditori = query.getResultList();
        em.close();
        return rivenditori;
    }

    @Override
    public void save(Rivenditore rivenditore) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(rivenditore);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Rivenditore rivenditore) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(rivenditore);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Rivenditore rivenditore) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Rivenditore toBeDeleted = em.merge(rivenditore);
        em.remove(toBeDeleted);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteById(Long id) {
        Rivenditore rivenditore = findById(id);
        delete(rivenditore);
    }
}
