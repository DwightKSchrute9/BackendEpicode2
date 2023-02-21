
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Tessera;

public class TesseraDaoImpl implements TesseraDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    @Override
    public Tessera findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Tessera tessera = em.find(Tessera.class, id);
        em.close();
        return tessera;
    }

    @Override
    public List<Tessera> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tessera> query = em.createQuery("SELECT t FROM Tessera t", Tessera.class);
        List<Tessera> tessere = query.getResultList();
        em.close();
        return tessere;
    }

    @Override
    public void save(Tessera tessera) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tessera);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Tessera tessera) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(tessera);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Tessera tessera) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Tessera toBeDeleted = em.merge(tessera);
        em.remove(toBeDeleted);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteById(Long id) {
        Tessera tessera = findById(id);
        delete(tessera);
    }
}
