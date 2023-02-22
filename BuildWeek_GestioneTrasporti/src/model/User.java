package model;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.findByCardNumber", query = "SELECT u FROM User u WHERE u.cardNumber = :cardNumber")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String surname;

  @Column(name = "card_number")
  private String cardNumber;

  public User() {
    // default constructor
  }

  public User(String name, String surname, String cardNumber) {
    this.name = name;
    this.surname = surname;
    this.cardNumber = cardNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public static User findUserByCardNumber(String cardNumber, EntityManager em) {
    TypedQuery<User> query = em.createNamedQuery("User.findByCardNumber", User.class);
    query.setParameter("cardNumber", cardNumber);
    return query.getSingleResult();
  }
}


