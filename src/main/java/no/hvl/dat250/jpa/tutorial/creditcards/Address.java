package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners = new HashSet<>();

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void addOwner(Customer owner) {
        this.owners.add(owner);
    }
}
