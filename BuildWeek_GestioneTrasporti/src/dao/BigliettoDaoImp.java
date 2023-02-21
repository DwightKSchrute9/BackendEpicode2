package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Biglietto;

public class BigliettoDaoImp implements BigliettoDao {

    private EntityManager entityManager;

    public BigliettoDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void aggiungiBiglietto(Biglietto biglietto) {
        entityManager.persist(biglietto);
    }

    @Override
    public void aggiornaBiglietto(Biglietto biglietto) {
        entityManager.merge(biglietto);
    }

    @Override
    public Biglietto getBigliettoById(int bigliettoId) {
        return entityManager.find(Biglietto.class, bigliettoId);
    }

    @Override
    public List<Biglietto> getAllTickets() {
        Query query = entityManager.createQuery("SELECT t FROM Biglietto t");
        return query.getResultList();
    }

    @Override
    public List<Biglietto> getBigliettiByPeriod(Date startDate, Date endDate) {
        Query query = entityManager.createQuery("SELECT t FROM Biglietto t WHERE t.emissionDateTime BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public List<Biglietto> getBigliettiByPointOfSale(int pointOfSaleId) {
        Query query = entityManager.createQuery("SELECT t FROM Biglietto t WHERE t.emissionPoint.id = :pointOfSaleId");
        query.setParameter("pointOfSaleId", pointOfSaleId);
        return query.getResultList();
    }

	@Override
	public List<Biglietto> getTicketsByPeriod(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biglietto> getTicketsByPointOfSale(int pointOfSaleId) {
		// TODO Auto-generated method stub
		return null;
	}
}
