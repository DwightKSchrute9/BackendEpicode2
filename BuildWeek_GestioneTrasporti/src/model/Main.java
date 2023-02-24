package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import util.JpaUtil;

public class Main {
  public static void main(String[] args) {
    // creazione entity manager factory
	  EntityManagerFactory emf = Persistence.createEntityManagerFactory("BuildWeek_GestioneTrasporti");

    // creazione entity manager
    EntityManager em = JpaUtil.getJpaEntityManager(emf);

    // codice per visualizzare la tabella user
    List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
    for (User u : users) {
      System.out.println(u.getName() + " " + u.getSurname());
    }

    // chiusura entity manager
    em.close();

    // chiusura entity manager factory
    emf.close();
  }
}
