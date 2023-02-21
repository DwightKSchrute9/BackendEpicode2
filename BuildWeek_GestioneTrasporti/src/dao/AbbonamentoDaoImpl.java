package dao;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Abbonamento;

public class AbbonamentoDaoImpl implements AbbonamentoDAO {

    private EntityManager entityManager;

    public AbbonamentoDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addAbbonamento(Abbonamento abbonamento) {
        entityManager.persist(abbonamento);
    }

    @Override
    public void updateAbbonamento(Abbonamento abbonamento) {
        entityManager.merge(abbonamento);
    }

    @Override
    public Abbonamento getAbbonamentoById(int abbonamentoId) {
        return entityManager.find(Abbonamento.class, abbonamentoId);
    }

    @Override
    public List<Abbonamento> getAllAbbonamenti() {
        Query query = entityManager.createQuery("SELECT a FROM Abbonamento a");
        return query.getResultList();
    }

    @Override
    public List<Abbonamento> getAbbonamentiByUser(int userId) {
        Query query = entityManager.createQuery("SELECT a FROM Abbonamento a WHERE a.user.id = :userId");
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Abbonamento> getAbbonamentiByPeriod(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Query query = entityManager.createQuery("SELECT a FROM Abbonamento a WHERE a.expirationDateTime >= :startDateTime AND a.expirationDateTime <= :endDateTime");
        query.setParameter("startDateTime", startDateTime);
        query.setParameter("endDateTime", endDateTime);
        return query.getResultList();
    }

}

