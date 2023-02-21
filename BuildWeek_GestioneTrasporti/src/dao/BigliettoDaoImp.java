package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.Biglietto;

public abstract class BigliettoDaoImp<endDate> implements BigliettoDao {

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

    public <Biglietto, Biglietto> Biglietto getBigliettoById(int bigliettoId) {
        return entityManager.find(Biglietto.class, bigliettoId);
    }

    @Override
    public List<Biglietto> getAllTickets() {
        Query query = entityManager.createQuery("SELECT t FROM Biglietto t");
        return query.getResultList();
    }

    @Override
    public List<Biglietto> getBigliettiByPeriod(Date startDate, Date endDate) {
        Query query = entityManager.createQuery("SELECT t FROM Biglietto t WHERE t.issueDate BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public List<Biglietto> getBigliettiByPointOfSale(int pointOfSaleId) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.pointOfSale.id = :pointOfSaleId");
        query.setParameter("pointOfSaleId", pointOfSaleId);
        return query.getResultList();
    }
}
