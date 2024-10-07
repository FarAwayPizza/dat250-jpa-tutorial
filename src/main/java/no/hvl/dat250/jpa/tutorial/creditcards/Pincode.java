package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    @OneToMany(mappedBy = "pincode")
    private Set<CreditCard> creditCards = new HashSet<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    // Helper method to add a credit card
    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
        creditCard.setPincode(this);
    }

    // New getCode method
    public String getCode() {
        return this.pincode;
    }

    public void setCode(String pincode) {
        this.pincode = pincode;
    }
}
