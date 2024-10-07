package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {

    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
         EntityManager em = factory.createEntityManager()) {

      em.getTransaction().begin();
      createObjects(em);  // Create and persist the objects based on the diagram
      em.getTransaction().commit();
    }
  }

  private static void createObjects(EntityManager em) {
    // Create Address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    // Create Customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    customer.getAddresses().add(address);  // Linking Address to Customer

    // Create Bank
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Create Pincode
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // Create first CreditCard
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(10000);
    creditCard1.setPincode(pincode);  // Linking Pincode to CreditCard
    creditCard1.setBank(bank);  // Linking Bank to CreditCard
    creditCard1.setOwner(customer);  // Linking Customer to CreditCard

    // Create second CreditCardss
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setPincode(pincode);  // Linking Pincode to CreditCard
    creditCard2.setBank(bank);  // Linking Bank to CreditCard
    creditCard2.setOwner(customer);  // Linking Customer to CreditCard
    //System.out.println("Credit Limit for creditCard1: " + creditCard1.getCreditLimit());


    // Linking Customer to CreditCards
    customer.getCreditCards().add(creditCard1);
    customer.getCreditCards().add(creditCard2);

    // Persist all objects
    em.persist(address);
    em.persist(customer);
    em.persist(bank);
    em.persist(pincode);
    em.persist(creditCard1);
    em.persist(creditCard2);

  }
}
