package org.bank.bankManagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DEPOSIT / WITHDRAW / TRANSFER
    private Double amount;
    private LocalDateTime transactionTime;

    @ManyToOne
    private Accounts account;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDateTime getTransactionTime() { return transactionTime; }
    public void setTransactionTime(LocalDateTime transactionTime) { this.transactionTime = transactionTime; }

    public Accounts getAccount() { return account; }
    public void setAccount(Accounts account) { this.account = account; }
}
