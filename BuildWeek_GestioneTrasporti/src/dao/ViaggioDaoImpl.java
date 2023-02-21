package dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import model.Viaggio;

import java.util.List;

public class ViaggioDaoImpl implements ViaggioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Viaggio save1(Viaggio viaggio) {
        entityManager.persist(viaggio);
        return viaggio;
    }

    @Transactional
    public Viaggio update1(Viaggio viaggio) {
        return entityManager.merge(viaggio);
    }

    @Transactional
    public void delete1(Viaggio viaggio) {
        entityManager.remove(entityManager.contains(viaggio) ? viaggio : entityManager.merge(viaggio));
    }

    public Viaggio findById(Long id) {
        return entityManager.find(Viaggio.class, id);
    }

    public List<Viaggio> findAll() {
        return entityManager.createQuery("SELECT v FROM Viaggio v", Viaggio.class).getResultList();
    }

	@Override
	public Viaggio save(Viaggio viaggio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viaggio update(Viaggio viaggio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Viaggio viaggio) {
		// TODO Auto-generated method stub
		
	}
}
