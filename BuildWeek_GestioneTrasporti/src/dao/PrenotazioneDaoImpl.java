
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Prenotazione;
import model.User;
import model.Viaggio;

public class PrenotazioneDaoImpl implements PrenotazioneDao {

private EntityManagerFactory emf;

public PrenotazioneDaoImpl(EntityManagerFactory emf) {
this.emf = emf;
}

@Override
public void saveOrUpdate(Prenotazione prenotazione) {
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();
try {
tx.begin();
em.merge(prenotazione);
tx.commit();
} catch (Exception e) {
e.printStackTrace();
tx.rollback();
} finally {
em.close();
}
}

@Override
public void delete(Prenotazione prenotazione) {
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();
try {
tx.begin();
em.remove(em.contains(prenotazione) ? prenotazione : em.merge(prenotazione));
tx.commit();
} catch (Exception e) {
e.printStackTrace();
tx.rollback();
} finally {
em.close();
}
}

@Override
public Prenotazione findById(Long id) {
EntityManager em = emf.createEntityManager();
Prenotazione prenotazione = em.find(Prenotazione.class, id);
em.close();
return prenotazione;
}

@Override
public List<Prenotazione> findAll() {
EntityManager em = emf.createEntityManager();
TypedQuery<Prenotazione> query = em.createQuery("SELECT p FROM Prenotazione p", Prenotazione.class);
List<Prenotazione> prenotazioni = query.getResultList();
em.close();
return prenotazioni;
}

@Override
public List<Prenotazione> findByUser(User user) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Prenotazione> findByViaggio(Viaggio viaggio) {
	// TODO Auto-generated method stub
	return null;
}

}