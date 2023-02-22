package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import model.User;


public class UserDaoImpl implements UserDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public UserDaoImpl() {
        emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");
        em = emf.createEntityManager();
    }

    @Override
    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(user);

        transaction.commit();
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);

        return query.getResultList();
    }

    @Override
    public void update(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(user);

        transaction.commit();
    }

    @Override
    public void delete(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(user);

        transaction.commit();
    }

    public List<User> findUsersByCardNumber(String cardNumber) {
        String jpql = "SELECT u FROM User u WHERE u.cardNumber = :cardNumber";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("cardNumber", cardNumber);

        return query.getResultList();
    }

    public List<User> findUsersByDateRange(Date startDate, Date endDate) {
        String jpql = "SELECT u FROM User u WHERE u.cardNumber IN (SELECT t.tessera.user.cardNumber FROM Tessera t WHERE t.dataEmissione BETWEEN :startDate AND :endDate)";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}


