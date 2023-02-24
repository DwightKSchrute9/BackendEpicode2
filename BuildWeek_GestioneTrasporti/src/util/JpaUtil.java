package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    private JpaUtil() {}

    public static EntityManager getJpaEntityManager() {
        return emf.createEntityManager();
    }

    public static EntityManager getJpaEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
