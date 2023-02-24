package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

private JpaUtil() {}

public static EntityManager getJpEntityManager() {
return emf.createEntityManager();
}

public static EntityManager getJpaEntityManager(EntityManagerFactory emf2) {
	// TODO Auto-generated method stub
	return null;
}
}