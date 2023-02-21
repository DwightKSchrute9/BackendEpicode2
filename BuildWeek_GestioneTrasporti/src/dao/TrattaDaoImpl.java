package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Tratta;

import java.util.List;

public class TrattaDaoImpl implements TrattaDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    @Override
    public Tratta findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Tratta tratta = em.find(Tratta.class, id);
        em.close();
        return tratta;
    }

    public List<Tratta> findAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Tratta> query = em.createQuery("SELECT t FROM Tratta t", Tratta.class);
        List<Tratta> tratte = query.getResultList();
        em.close();
        return tratte;
    }

    @Override
    public void save(Tratta tratta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(tratta);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Tratta tratta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(tratta);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Tratta tratta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Tratta toBeDeleted = em.merge(tratta);
        em.remove(toBeDeleted);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        Tratta tratta = findById(id);
        delete(tratta);
    }

	public void save1(Tratta tratta) {
		// TODO Auto-generated method stub
		
	}

	public void update1(Tratta tratta) {
		// TODO Auto-generated method stub
		
	}

	public void delete1(Tratta tratta) {
		// TODO Auto-generated method stub
		
	}
}

