package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private Set<CreditCard> ownedCards = new HashSet<CreditCard>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void addOwnedCards(Collection<CreditCard> ownedCards) {
        this.ownedCards = (Set<CreditCard>) ownedCards;
    }
}
