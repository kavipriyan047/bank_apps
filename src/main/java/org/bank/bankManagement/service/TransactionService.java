package org.bank.bankManagement.service;

import org.bank.bankManagement.entity.Accounts;
import org.bank.bankManagement.entity.Transaction;
import org.bank.bankManagement.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction deposit(Accounts account, Double amount) {
        account.setBalance(account.getBalance() + amount);
        Transaction t = new Transaction();
        t.setType("DEPOSIT");
        t.setAmount(amount);
        t.setTransactionTime(LocalDateTime.now());
        t.setAccount(account);
        return transactionRepository.save(t);
    }

    public Transaction withdraw(Accounts account, Double amount) {
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        Transaction t = new Transaction();
        t.setType("WITHDRAW");
        t.setAmount(amount);
        t.setTransactionTime(LocalDateTime.now());
        t.setAccount(account);
        return transactionRepository.save(t);
    }
}
