

package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Mezzo;

public class MezzoDaoImpl implements MezzoDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    @Override
    public Mezzo findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Mezzo mezzo = em.find(Mezzo.class, id);
        em.close();
        return mezzo;
    }

    @Override
    public List<Mezzo> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m", Mezzo.class);
        List<Mezzo> mezzi = query.getResultList();
        em.close();
        return mezzi;
    }

    @Override
    public void save(Mezzo mezzo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(mezzo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Mezzo mezzo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(mezzo);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Mezzo mezzo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Mezzo toBeDeleted = em.merge(mezzo);
        em.remove(toBeDeleted);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteById(Long id) {
        Mezzo mezzo = findById(id);
        delete(mezzo);
    }
}
