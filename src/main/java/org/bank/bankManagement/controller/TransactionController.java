package org.bank.bankManagement.controller;

import org.bank.bankManagement.entity.Accounts;
import org.bank.bankManagement.entity.Transaction;
import org.bank.bankManagement.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody Accounts account, @RequestParam Double amount) {
        return transactionService.deposit(account, amount);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestBody Accounts account, @RequestParam Double amount) {
        return transactionService.withdraw(account, amount);
    }
}
