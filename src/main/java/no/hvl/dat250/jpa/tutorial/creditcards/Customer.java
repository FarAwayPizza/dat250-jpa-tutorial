package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<CreditCard> creditCard = new HashSet<>();

    @ManyToMany
    private Set<Address> addresses = new HashSet<>();

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        address.addOwner(this); // Add customer to the address owners
        this.addresses.add(address); // Add address to customer
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCard.add(creditCard);
    }

    public Set<CreditCard> getCreditCards() {
        return creditCard;
    }
}
