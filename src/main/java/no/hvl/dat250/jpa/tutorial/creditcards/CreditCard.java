package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer creditLimit;
    private Integer balance;


    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Customer owner;


    @ManyToOne
    private Bank owningBank;

    // Getters and Setters

    public Integer getNumber() { return number; }
    public void setNumber(Integer number) { this.number = number; }

    public Integer getBalance() { return balance; }
    public void setBalance(Integer balance) { this.balance = balance; }

    public Integer getCreditLimit() { return creditLimit; }
    public void setCreditLimit(Integer creditLimit) { this.creditLimit = creditLimit; }

    public Pincode getPincode() { return pincode; }
    public void setPincode(Pincode pinCode) { this.pincode = pinCode; }

    public void setOwner(Customer owner) { this.owner = owner; }

    public Bank getOwningBank() { return owningBank; }
    public void setBank(Bank bank) {
        this.owningBank = bank;
    }
}
